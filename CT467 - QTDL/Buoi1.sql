-- Bai 3.1
create schema qldiem;
use qldiem;

create table khoa(
	maKhoa char(8) primary key,
    tenKhoa varchar(50) not null
);

create table hocPhan(
	maHP char(6) primary key,
    tenHP varchar(50) not null,
    soTinChi int not null,
    soTietLT int not null,
    soTietTH int not null
);

create table sinhVien(
	mssv char(8) primary key,
    hoten varchar(45) not null,
    gioiTinh char(1) not null,
    ngaySinh date not null,
    noiSinh varchar(40) not null,
    diaChi varchar(100) not null,
    maKhoa char(8) not null,
    foreign key (maKhoa) references khoa(maKhoa)
);

create table ketQua(
	mssv char(8) not null,
    maHP char(6) not null,
    diem float,
    primary key(mssv, maHP),
    foreign key (mssv) references sinhVien(mssv),
    foreign key (maHP) references hocPhan(maHP)
);

-- Bai 3.2 
insert into hocPhan values('CT101', 'Lập trình căn bản', 4, 30, 60);
insert into hocPhan values('CT176', 'Lập trình hướng đối tượng', 3, 30, 30);
insert into hocPhan values('CT237', 'Nguyên lý hệ điều hành', 3, 30, 30);
insert into hocPhan values('TN001', 'Vi Tích Phân A1', 3, 45, 0);
insert into hocPhan values('TN101', 'Xác suất thống kê', 3, 45, 0);
insert into hocPhan values('SP102', 'Đại số tuyến tính', 4, 60, 0);
insert into hocPhan values('TN172', 'Toán rời rạc', 4, 60, 0);

insert into khoa values('ktqtkd', 'Kinh tế và quản trị kinh doanh');
insert into khoa values('cntt&tt', 'Công nghệ thông tin và Truyền thông');
insert into khoa values('khtn', 'Khoa học tự nhiên');
insert into khoa values('khxh', 'Khoa học xã hội');
insert into khoa values('sp', 'sư phạm');

insert into sinhVien values('B1234567', 'Nguyễn Thanh Hải', 'M', '2001-12-02', 'Bạc Liêu', 'Phòng 01, KTX Khu B, ĐHCT', 'cntt&tt');
insert into sinhVien values('B1234568', 'Trần Thanh Mai', 'M', '2001-01-20', 'Cần Thơ', '232 Nguyễn	Văn	Khéo, Q. Ninh Kiều, TPCT', 'cntt&tt');
insert into sinhVien values('B1234569', 'Trần Thu Thủy', 'F', '2001-07-01', 'Cần Thơ', '02,	Đại	lộ Hòa Bình, Q. Ninh Kiều, TPCT', 'cntt&tt');	
insert into sinhVien values('B1334569', 'Nguyễn Thị Trúc Mã', 'F', '2002-05-25', 'Sóc Trăng', '343,	Đường 30/4, Q. Ninh Kiều, TPCT', 'sp');
insert into sinhVien values('B1345678', 'Trần Hồng Trúc', 'F', '2002-03-02', 'Cần Thơ', '123, Trần Hưng Đạo, Q. Ninh Kiều, TPCT', 'cntt&tt');
insert into sinhVien values('B1345679', 'Bùi Hoàng Yến', 'F', '2001-11-05', 'Vĩnh Long', 'Phòng 201, KTX Khu A, ĐHCT', 'cntt&tt');
insert into sinhVien values('B1456789', 'Trần Trọng Kim', 'M', '2003-05-10', 'Kiên Giang', 'Phòng 101, KTX Khu A, ĐHCT', 'khtn');
insert into sinhVien values('B1456790', 'Lê Bạch Yến', 'F', '2003-10-20', 'Kiên Giang', '177, Đường 3/2, Q. Ninh Kiều, TPCT', 'khtn');

insert into ketQua values('B1234567', 'CT101', 4);
insert into ketQua values('B1234568', 'CT176', 8);
insert into ketQua values('B1234569', 'CT237', 9);
insert into ketQua values('B1334569', 'SP102', 2);
insert into ketQua values('B1345678', 'CT101', 6);
insert into ketQua values('B1345679', 'CT176', 5);
insert into ketQua values('B1456789', 'TN172', 10);
insert into ketQua values('B1456790', 'TN172', 7);
insert into ketQua values('B1234567', 'CT176', 1);
insert into ketQua values('B1234568', 'CT101', 9);
insert into ketQua values('B1234569', 'CT101', 8);
insert into ketQua values('B1334569', 'CT101', 4);
insert into ketQua values('B1345678', 'TN001', 6);
insert into ketQua values('B1345679', 'CT101', 2);
insert into ketQua values('B1456789', 'CT101', 7);
insert into ketQua values('B1456790', 'CT101', 6);

-- Bai 4	
-- 4.1 Hiển thị danh sách sinh viên sắp xếp tăng dần theo MSSV
SELECT mssv, hoten, ngaySinh FROM sinhVien ORDER BY mssv ASC;

-- 4.2 Hiển thị danh sách các SV (MSSV, họ tên) thuộc khoa "Công nghệ thông tin và Truyền thông"
SELECT sv.mssv, sv.hoten FROM sinhVien sv JOIN khoa k ON sv.maKhoa = k.maKhoa WHERE k.tenKhoa = "Công nghệ thông tin và Truyền thông";

-- 4.3 Hiển thị bảng điểm bao gồm các thông tin sau: MSSV, họ tên, tên học phần, điểm.
SELECT sv.mssv, sv.hoten, d.diem, h.tenHP FROM sinhVien sv JOIN ketQua d ON sv.mssv = d.mssv JOIN hocPhan h ON d.maHP = h.maHP;

-- 4.4 Hiển thị MSSV và họ tên các SV nữ sinh năm 2001.
SELECT mssv, hoten from sinhVien where gioiTinh = 'F' AND YEAR(ngaySinh) = 2001;

-- 4.5 Hiển thị danh sách bao gồm MSSV, họ tên, số học phần đã học và điểm trung bình.
SELECT sv.mssv, sv.hoten, COUNT(kq.maHP), AVG(kq.diem) from sinhVien sv LEFT JOIN ketQua kq ON sv.mssv = kq.mssv GROUP BY sv.mssv, sv.hoten;

-- 4.6 Hiển thị danh sách các môn học chưa có SV học.
SELECT maHP, tenHP from hocPhan WHERE maHP NOT IN (SELECT maHP from ketQua);

-- 4.7 Hiển thị các sinh viên có điểm trung bình lớn nhất.
SELECT sv.mssv, sv.hoten, AVG(kq.diem) AS DiemTB FROM sinhVien sv JOIN ketQua kq ON sv.mssv = kq.mssv GROUP BY sv.mssv, sv.hoten
HAVING AVG(kq.diem) = (
    SELECT MAX(dtb.trungbinh) FROM (SELECT AVG(diem) AS trungbinh FROM ketQua GROUP BY mssv) AS dtb
);

-- 4.8 Hiển thị danh sách SV có điểm trung bình nhỏ hơn trung bình của các điểm trung bình của tat ca cac SV.
SELECT sv.mssv, sv.hoten, AVG(kq.diem) AS Diem_Trung_Binh FROM sinhVien sv JOIN ketQua kq ON sv.mssv = kq.mssv GROUP BY sv.mssv, sv.hoten
HAVING AVG(kq.diem) < (
    SELECT AVG(dtb_tung_sv) FROM (SELECT AVG(diem) AS dtb_tung_sv FROM ketQua GROUP BY mssv) AS bang_tam
);

-- 4.9 Hiển thị danh sách các Khoa cùng với số sinh viên tương ứng của Khoa đó.
SELECT k.maKhoa, k.tenKhoa, COUNT(sv.mssv) FROM khoa k LEFT JOIN sinhVien sv ON k.maKhoa = sv.maKhoa GROUP BY k.maKhoa, k.tenKhoa;

-- 4.10 Hiển thị khoa có nhiều SV nhất.
SELECT k.maKhoa, k.tenKhoa, COUNT(sv.mssv) FROM khoa k LEFT JOIN sinhVien sv ON k.maKhoa = sv.maKhoa GROUP BY k.maKhoa, k.tenKhoa ORDER BY COUNT(sv.mssv) DESC LIMIT 1;

-- 4.11 Cập nhật lại điểm của các sinh viên không thuộc Khoa CNTT&TT học môn CT101 lên mỗi SV 1 điểm.
UPDATE ketQua SET diem = diem + 1 WHERE maHP = 'CT101' AND mssv IN (SELECT mssv FROM sinhVien WHERE maKhoa != 'cntt&tt');