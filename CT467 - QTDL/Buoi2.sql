use qldiem;

-- Bai1
-- 1.1 Thủ tục THEM_SV cho phép thêm sinh viên mới vào CSDL với các tham số: MSSV, họ tên, giới tính, ngày sinh, nơi sinh, địa chỉ, tên khoa
DELIMITER //
CREATE PROCEDURE THEM_SV(
    IN p_mssv CHAR(8),
    IN p_hoten VARCHAR(45),
    IN p_gioiTinh CHAR(1),
    IN p_ngaySinh DATE,
    IN p_noiSinh VARCHAR(40),
    IN p_diaChi VARCHAR(100),
    IN p_tenKhoa VARCHAR(50)
)
BEGIN 
	DECLARE v_maKhoa CHAR(8);
    SELECT maKhoa INTO v_maKhoa FROM khoa WHERE tenKhoa = p_tenKhoa LIMIT 1;
    INSERT INTO sinhVien (mssv, hoten, gioiTinh, ngaySinh, noiSinh, diaChi, maKhoa) VALUES (p_mssv, p_hoten, p_gioiTinh, p_ngaySinh, p_noiSinh, p_diaChi, v_maKhoa);
END //
DELIMITER ;

-- 1.2 Thủ tục XOA_SV cho phép xóa sinh viên trong CSDL. Thủ tục này nhận vào 1 MSSV, nếu MSSV tồn tại thì xóa hết các kết quả của sinh viên đó trước khi xóa SV ra khỏi CSDL
DROP PROCEDURE IF EXISTS XOA_SV;
DELIMITER //
CREATE PROCEDURE XOA_SV(
    IN p_mssv CHAR(8)
)
BEGIN
	DELETE FROM ketQua WHERE mssv = p_mssv;
    DELETE FROM sinhVien WHERE mssv = p_mssv;
END //
DELIMITER ;

-- 1.3 Thủ tục DIEM_TB, nhận vào MSSV và trả về điểm trung bình của sinh SV có MSSV tương ứng thông qua output parameter. Nếu MSSV truyền vào không có thì trả về -1. 
DROP PROCEDURE IF EXISTS DIEM_TB;
DELIMITER //
CREATE PROCEDURE DIEM_TB(
    IN p_mssv CHAR(8),
    OUT p_diemTB FLOAT
)
BEGIN
    IF NOT EXISTS (SELECT 1 FROM sinhVien WHERE mssv = p_mssv) THEN SET p_diemTB = -1;
    ELSE
        SELECT AVG(diem) INTO p_diemTB FROM ketQua WHERE mssv = p_mssv;
        IF p_diemTB IS NULL THEN SET p_diemTB = -1;
        END IF;
    END IF;
END //
DELIMITER ;

-- 1.4 Tương tự như câu 3 nhưng viết hàm
DROP FUNCTION IF EXISTS TINH_DIEM_TB;
DELIMITER //
CREATE FUNCTION TINH_DIEM_TB(p_mssv CHAR(8)) RETURNS FLOAT DETERMINISTIC
BEGIN
    DECLARE v_diemTB FLOAT;
    IF NOT EXISTS (SELECT 1 FROM sinhVien WHERE mssv = p_mssv) THEN
		RETURN -1;
    END IF;
    SELECT AVG(diem) INTO v_diemTB FROM ketQua WHERE mssv = p_mssv;
    IF v_diemTB IS NULL THEN
        RETURN -1;
    END IF;
    RETURN v_diemTB;
END //
DELIMITER ;

SELECT TINH_DIEM_TB('B1234567') AS Diem_Trung_Binh;

-- 1.5 Thủ tục BANG_DIEM_TB nhận vào một mã khoa và trả về bảng điểm trung bình của các sinh viên thuộc khoa đó
DROP PROCEDURE IF EXISTS BANG_DIEM_TB;
DELIMITER //
CREATE PROCEDURE BANG_DIEM_TB(
    IN p_maKhoa CHAR(8)
)
BEGIN
    SELECT sv.mssv, sv.hoten, sv.ngaySinh, k.tenKhoa, TINH_DIEM_TB(sv.mssv) FROM sinhVien sv 
    JOIN khoa k ON sv.maKhoa = k.maKhoa WHERE sv.maKhoa = p_maKhoa ORDER BY sv.mssv ASC;
END //
DELIMITER ;

-- 1.6 Viết hàm TOT_NGHIEP kiểm tra một sinh viên có đủ điều kiện tốt nghiệp hay không. Hàm nhận vào một MSSV và trả về TRUE (nonzero) nếu sinh viên đủ điều kiện tốt nghiệp và FALSE (zero) nếu không đủ điều kiện. 
DROP PROCEDURE IF EXISTS TOT_NGHIEP;
DROP FUNCTION IF EXISTS TOT_NGHIEP;
DELIMITER //
CREATE FUNCTION TOT_NGHIEP(p_mssv CHAR(8)) RETURNS BOOLEAN DETERMINISTIC
BEGIN
    DECLARE v_diemTB FLOAT;
    DECLARE v_soMonDuoiTrungBinh INT;
    SET v_diemTB = TINH_DIEM_TB(p_mssv);
	IF v_diemTB = -1 THEN
        RETURN FALSE;
    END IF;
    SELECT COUNT(*) INTO v_soMonDuoiTrungBinh FROM ketQua WHERE mssv = p_mssv AND diem < 4;
    IF v_diemTB >= 5.0 AND v_soMonDuoiTrungBinh = 0 THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END //
DELIMITER ;

-- 1.7 Viết hàm LOAI_TOT_NGHIEP nhận vào một MSSV và trả về loại tốt nghiệp của sinh viên (dựa vào qui chế học vụ của Trường ĐHCT).
DROP FUNCTION IF EXISTS LOAI_TOT_NGHIEP;
DELIMITER //
CREATE FUNCTION LOAI_TOT_NGHIEP(p_mssv CHAR(8)) RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
    DECLARE v_diem10 FLOAT;
    DECLARE v_diem4 FLOAT;
    DECLARE v_xepLoai VARCHAR(20);
    SET v_diem10 = TINH_DIEM_TB(p_mssv);
    IF v_diem10 = -1 THEN
        RETURN 'Không xác định';
    END IF;
    SET v_diem4 = (v_diem10 / 10) * 4;
    IF v_diem4 >= 3.6 THEN SET v_xepLoai = 'Xuất sắc';
    ELSEIF v_diem4 >= 3.2 THEN SET v_xepLoai = 'Giỏi';
    ELSEIF v_diem4 >= 2.5 THEN SET v_xepLoai = 'Khá';
    ELSEIF v_diem4 >= 2.0 THEN SET v_xepLoai = 'Trung bình';
    ELSE SET v_xepLoai = 'Không đạt';
    END IF;
    RETURN v_xepLoai;
END //
DELIMITER ;

-- 1.8 Viết thủ tục SV_TOT_NGHIEP nhận vào mã khoa và liệt kê các sinh viên đủ điều kiện tốt nghiệp của khoa đó, có sử dụng hàm đã viết trong Câu 6) và 7) và con trỏ để xử lý. Các thông tin cần hiển thị là MSSV, họ tên, số tín chỉ đã học, điểm trung bình, loại tốt nghiệp.
DROP PROCEDURE IF EXISTS SV_TOT_NGHIEP;
DELIMITER //
CREATE PROCEDURE SV_TOT_NGHIEP(
    IN p_maKhoa CHAR(8)
)
BEGIN
    DECLARE v_mssv CHAR(8);
    DECLARE v_hoten VARCHAR(45);
    DECLARE v_tongTinChi INT;
    DECLARE v_diemTB FLOAT;
    DECLARE v_loaiTN VARCHAR(20);
    DECLARE v_finished INT DEFAULT 0;
    DECLARE sv_cursor CURSOR FOR SELECT mssv, hoten FROM sinhVien WHERE maKhoa = p_maKhoa;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;
	SET SQL_SAFE_UPDATES = 0;
    CREATE TEMPORARY TABLE IF NOT EXISTS KetQuaTotNghiep (
        MSSV CHAR(8),
        HoTen VARCHAR(45),
        SoTinChi INT,
        DiemTB FLOAT,
        LoaiTN VARCHAR(20)
	);
    DELETE FROM KetQuaTotNghiep;
    OPEN sv_cursor;
    get_sv: LOOP
        FETCH sv_cursor INTO v_mssv, v_hoten;
        IF v_finished = 1 THEN LEAVE get_sv;
        END IF;
        IF TOT_NGHIEP(v_mssv) = 1 THEN
            SET v_diemTB = TINH_DIEM_TB(v_mssv);
            SET v_loaiTN = LOAI_TOT_NGHIEP(v_mssv);
            SELECT SUM(hp.soTinChi) INTO v_tongTinChi FROM ketQua kq JOIN hocPhan hp ON kq.maHP = hp.maHP WHERE kq.mssv = v_mssv;
            IF v_tongTinChi IS NULL THEN SET v_tongTinChi = 0; END IF;
            INSERT INTO KetQuaTotNghiep VALUES (v_mssv, v_hoten, v_tongTinChi, v_diemTB, v_loaiTN);
        END IF;
    END LOOP get_sv;
    CLOSE sv_cursor;
    SELECT * FROM KetQuaTotNghiep;
END //
DELIMITER ;

-- 1.9 Viết hàm SL_SV_KHOA nhận vào tên Khoa và trả về số lượng SV của Khoa đó.
DROP FUNCTION IF EXISTS SL_SV_KHOA;
DELIMITER //
CREATE FUNCTION SL_SV_KHOA(p_tenKhoa VARCHAR(50)) RETURNS INT DETERMINISTIC
BEGIN
    DECLARE v_count INT DEFAULT 0;
    DECLARE v_maKhoa CHAR(8);
    SELECT maKhoa INTO v_maKhoa FROM khoa WHERE tenKhoa = p_tenKhoa LIMIT 1;
    IF v_maKhoa IS NULL THEN RETURN 0;
    END IF;
    SELECT COUNT(*) INTO v_count FROM sinhVien WHERE maKhoa = v_maKhoa;
    RETURN v_count;
END //
DELIMITER ;

-- 1.10 Viết thủ tục SV_LOAI nhận vào một tên loại (giỏi, khá, trung bình, ... ) và trả về danh sách sinh viên (bao gồm MSSV, họ tên) có loại tương ứng cho lời gọi thủtục (sử dụng hàm LOAI_TOT_NGHIEP bên trên).
DROP PROCEDURE IF EXISTS SV_LOAI;
DELIMITER //
CREATE PROCEDURE SV_LOAI(
    IN p_tenLoai VARCHAR(20)
)
BEGIN
    SELECT mssv, hoten, LOAI_TOT_NGHIEP(mssv) FROM sinhVien WHERE LOAI_TOT_NGHIEP(mssv) = p_tenLoai;
END //
DELIMITER ;
