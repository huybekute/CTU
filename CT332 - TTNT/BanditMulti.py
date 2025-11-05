import numpy as np
import matplotlib.pyplot as plt
from matplotlib.animation import FuncAnimation, PillowWriter, FFMpegWriter

# --- Bandit setup ---
np.random.seed(42)

# Gacha settings
gachas_name = ["A", "B", "C"]
win_props = np.array([0.02, 0.01, 0.005])         
win_values = np.array([5_000_000, 8_000_000, 10_000_000]) 
cost_per_play = 1000
n_arms = len(gachas_name)
n_rounds = 200

# loi nhuan ky vong
true_expected_net = win_props * win_values - cost_per_play
optimal_expected_net = np.max(true_expected_net)

# --- Policies setup ---
epsilon = 0.1
policies = ['eps_greedy', 'ucb', 'thompson']
titles = ["ε-Greedy (ε=0.1)", "UCB1", "Thompson Sampling"]

# --- Arm colors ---
arm_colors = ['tab:red', 'tab:green', 'tab:orange']

# --- Initialize estimates ---
Q_eps = np.zeros(n_arms)
N_eps = np.zeros(n_arms)
Q_ucb = np.zeros(n_arms)
N_ucb = np.zeros(n_arms)
alpha_ts = np.ones(n_arms)
beta_ts = np.ones(n_arms)

# --- Histories ---
histories = {p: [] for p in policies}

# --- Policy functions ---
def select_epsilon_greedy():
    if np.random.rand() < epsilon:
        return np.random.randint(n_arms)
    return np.argmax(Q_eps)

def select_ucb(t):
    if 0 in N_ucb:
        return np.argmin(N_ucb)
    ucb_values = Q_ucb + np.sqrt(2 * np.log(t + 1) / N_ucb)
    return np.argmax(ucb_values)

def select_thompson():
    samples = np.random.beta(alpha_ts, beta_ts)
    return np.argmax(samples)

def update_estimates(policy, a, r, win=None):
    if policy == 'eps_greedy':
        N_eps[a] += 1
        Q_eps[a] += (r - Q_eps[a]) / N_eps[a]
    elif policy == 'ucb':
        N_ucb[a] += 1
        Q_ucb[a] += (r - Q_ucb[a]) / N_ucb[a]
    elif policy == 'thompson':
        alpha_ts[a] += win
        beta_ts[a] += (1 - win)

def run_one_step(policy, t):
    if policy == 'eps_greedy':
        a = select_epsilon_greedy()
    elif policy == 'ucb':
        a = select_ucb(t)
    else:
        a = select_thompson()

    # Gacha roll
    win = np.random.rand() < win_props[a]
    reward = win_values[a] if win else 0
    net_reward = reward - cost_per_play

    update_estimates(policy, a, net_reward, win)
    histories[policy].append((t, a, net_reward, win))

# --- Figure setup ---
fig, axes = plt.subplots(3, 2, figsize=(10, 8))
plt.tight_layout(pad=3.0)
bars = []

for i, policy in enumerate(policies):
    ax_top, ax_bottom = axes[i]

    # Scatter plot actions
    ax_top.set_xlim(0, n_rounds)
    ax_top.set_ylim(-0.5, n_arms - 0.5)
    ax_top.set_yticks(range(n_arms))
    ax_top.set_yticklabels([f"{gachas_name[j]} (p={win_props[j]:.3f})" for j in range(n_arms)])
    ax_top.set_title(titles[i])

    # Estimated values
    ax_bottom.set_ylim(0, 1)
    bars_plot = ax_bottom.bar(range(n_arms), [0]*n_arms, color=arm_colors, alpha=0.7)
    bars.append(bars_plot)
    ax_bottom.set_xticks(range(n_arms))
    ax_bottom.set_xticklabels(gachas_name)
    ax_bottom.set_ylabel("Estimated θ")

# --- Animation update ---
def update(frame):
    for i, policy in enumerate(policies):
        run_one_step(policy, frame)

        t_list = [h[0] for h in histories[policy]]
        arm_list = [h[1] for h in histories[policy]]
        reward_list = [h[2] for h in histories[policy]]
        win_list = [h[3] for h in histories[policy]]

        # Clear previous scatters
        for coll in list(axes[i, 0].collections):
            coll.remove()

        # Draw new scatter points
        for arm in range(n_arms):
            arm_times = [t for t, a in zip(t_list, arm_list) if a == arm]
            arm_wins = [w for a, w in zip(arm_list, win_list) if a == arm]
            x_empty = [t for t, w in zip(arm_times, arm_wins) if not w]
            y_empty = [arm] * len(x_empty)
            x_filled = [t for t, w in zip(arm_times, arm_wins) if w]
            y_filled = [arm] * len(x_filled)

            axes[i, 0].scatter(x_empty, y_empty, facecolors='none',
                               edgecolors=arm_colors[arm], s=50, linewidths=1.5)
            axes[i, 0].scatter(x_filled, y_filled, color=arm_colors[arm], s=50)

        # Update estimated parameters
        if policy == 'eps_greedy':
            est = Q_eps.copy()
        elif policy == 'ucb':
            est = Q_ucb.copy()
        else:
            est = alpha_ts / (alpha_ts + beta_ts)

        for j, b in enumerate(bars[i]):
            b.set_height(est[j])

    return [b for bar in bars for b in bar]

# --- Run animation ---
anim = FuncAnimation(fig, update, frames=n_rounds, interval=120, blit=False, repeat=False)

# # --- Save GIF & MP4 ---
# anim.save("bandit_compare.gif", writer=PillowWriter(fps=15))
# anim.save("bandit_compare.mp4", writer=FFMpegWriter(fps=15))

plt.show()
