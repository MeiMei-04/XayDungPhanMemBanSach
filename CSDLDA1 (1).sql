--create database QuanLyBanSach
--Drop database QuanLyBanSach
use QuanLyBanSach
-- Tạo Bảng Chức Vụ
Create Table ChucVu(
	ID_CV int identity(1,1) primary key not null,
	MA_CV as 'CV' + cast(ID_CV as nvarchar(5)) persisted,
	TenCV nvarchar(50) not null,
	TrangThai int not null
);
-- Tạo Bảng Tài Khoản
Create Table TaiKhoan(
    ID_TK int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	Ma_TK as 'TK' + cast(ID_TK as nvarchar(5)) persisted,
    ID_CV INT not NULL,
    TaiKhoan varchar(50) not null,
    MatKhau VARCHAR(50) not null,
    Email VARCHAR(50) not NULL,
    NgayTao DATETIME Not NULL,
    SDT varchar(15) not null,
    NgaySinh DATE not null,
    DiaChi nvarchar(255) not null,
    TrangThai int not null,
    FOREIGN key (ID_CV) REFERENCES ChucVu(ID_CV)
);
-- Tạo Bảng Thể Loại
CREATE TABLE TheLoai(
    ID_TL int IDENTITY(1,1) primary KEY not NULL,
	Ma_TL as 'TL' + cast(ID_TL as nvarchar(5)) persisted,
	TenTL Nvarchar(50) not null,
    Mota NVARCHAR(255) null,
    TrangThai int not null
);
-- Tạo Bảng Tác Giả
CREATE TABLE TacGia(
    id_TG int IDENTITY(1,1) primary KEY not null,
	Ma_TG as 'TG' + cast(ID_TG as nvarchar(5)) persisted,
    TenTG NVARCHAR(50) not null,
    NgaySinh Date null,
    QuocTich NVARCHAR(50) null,
    TrangThai int not null
);
-- Tạo Bảng Nhà Xuất Bản
CREATE TABLE NhaXuatBan(
    ID_NXB int IDENTITY(1,1) primary key not null,
	Ma_NXB as 'NXB' + cast(ID_NXB as nvarchar(5)) persisted,
    TenNXB NVARCHAR(50) not null,
    DiaChiNXB NVARCHAR(255) null,
    TrangThai int not null
);
--Tạo Bảng Khu vực Lưu Trữ
CREATE TABLE KhuVucLuuTru(
    ID_KV int IDENTITY(1,1) PRIMARY KEY not null,
	Ma_KV as 'KV' + cast(ID_KV as nvarchar(5)) persisted,
    TenKV NVARCHAR(50) not null,
    TrangThai int Not NULL
);
--Tạo bảng NGôn Ngữ Sản Phẩm
CREATE TABLE NgonNguSanPham(
    ID_NN int IDENTITY(1,1) PRIMARY KEY Not null,
	Ma_NN as 'NN' + cast(ID_NN as nvarchar(5)) persisted,
    TenNN nvarchar(50) not null,
    TrangThai int not null
);
--Tạo bảng khách hàng;
CREATE TABLE KhachHang(
    ID_KH int IDENTITY(1,1) PRIMARY KEY not null,
	Ma_KH as 'KH' + cast(ID_KH as nvarchar(5)) persisted,
    TenKH NVARCHAR(50) not null,
    SDT nvarchar(15) null,
    DiaChi NVARCHAR(255) null,
    GioiTinh int null,
    NgayTao DateTime null,
    TrangThai int not null
);
--Tạo Bảng Mã Giảm Giá
Create TABLE MaGiamGia(
    ID_MGG int IDENTITY(1,1) PRIMARY KEY not null,
    Ma_GG varchar(20) not null,
    Mota NVARCHAR(255) not null,
    Giatri int not null,
    NgayTao DATETIME not null,
    NgayHetHan DATETIME not null,
    SoLuong int not null,
    DieuKien int not null,
    TienGiamToiDa int not null,
    TrangThai int not null
);
-- Tạo bảng Hoá Đơn
Create TABLE HoaDon(
    ID_Hd int IDENTITY(1,1) PRIMARY KEY not null,
    ID_TK int not null,
    ID_Kh int not null,
	Ma_HD as 'HD' + cast(ID_HD as nvarchar(5)) persisted,
    TenNguoiMua NVARCHAR(50) not null,
    SDTNguoiMua varchar(15) not null,
    NgayTao DATETIME not null,
    NgayThanhToan DATETIME not null,
    TongTienGoc int not null,
    TongTienSauGiamGia int not null,
    TrangThai int not null
    FOREIGN KEY (ID_TK) REFERENCES TaiKhoan(ID_TK),
    FOREIGN KEY (ID_KH) REFERENCES KhachHang(ID_KH)
);
-- Tạo bảng Mã Giảm Giá Hoá Đơn
CREATE TABLE MaGiamGiaHoaDon(
    ID_MGGHD int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    ID_Hd int not null,
    ID_MGG int not null,
    NgaySuDung DATETIME not null,
    TrangThai int not null,
	FOREIGN KEY (ID_Hd) REFERENCES HoaDon(ID_Hd),
    FOREIGN KEY (ID_MGG) REFERENCES MaGiamGia(ID_MGG)
);
-- Tạo Bảng Sách
CREATE TABLE Sach(
    ID_Sach int IDENTITY(1,1) PRIMARY KEY not null,
    ID_KV int not null,
    ID_NXB int not null,
	ID_TG int not null,
	ID_TL int not null,
	Ma_SACH as 'SACH' + cast(ID_Sach as nvarchar(5)) persisted,
    TenSach NVARCHAR(255) not null,
    NamSanXuat int not null,
    SoLuongSanPham int not null,
    GiaSanPham int not null,
    SoTrang int Not null,
    MoTa NVARCHAR(255) not null,
    TrangThai int not null,
	FOREIGN KEY (ID_KV) REFERENCES KhuVucLuuTru(ID_KV),
    FOREIGN KEY (ID_NXB) REFERENCES NhaXuatBan(ID_NXB),
	FOREIGN KEY (ID_TG) REFERENCES TacGia(ID_TG),
	FOREIGN KEY (ID_TL) REFERENCES TheLoai(ID_TL)
);
-- Tạo Bảng Ảnh
CREATE TABLE AnhSach(
    id_Anh int IDENTITY(1,1) PRIMARY KEY not null,
	MA_ANH as 'ANH' + cast(id_anh as nvarchar(5)) persisted,
    id_Sach int not null,
    TenAnh varchar(50) not null,
    TrangThai int not null,
	FOREIGN KEY (ID_Sach) REFERENCES Sach(ID_Sach)
);
--Tạo Bảng Chi Tiết Hoá Đơn
CREATE TABLE ChitietHoaDon(
    ID_CTHD int IDENTITY(1,1) PRIMARY KEY not null,
	Ma_CTHD as 'CTHD' + cast(ID_CTHD as nvarchar(5)) persisted,
    id_hd INT NOT NULL,
    ID_Sach int not null,
    SoLuong int not null,
    Gia int not null,
    TrangThai int not null,
	FOREIGN KEY (id_hd) REFERENCES HoaDon(id_hd),
	FOREIGN KEY (ID_Sach) REFERENCES Sach(ID_Sach)
);

--Tạo Trạng Thái Thanh Toán
CREATE TABLE PhuongThucThanhToan(
    ID_PTTT int IDENTITY(1,1) PRIMARY KEY Not null,
    MaKieuGD as 'KGD' + cast(ID_PTTT as nvarchar(5)) persisted,
    TenPT NVARCHAR(50) NOT NULL,
    TrangThai int not null
)
--Tạo Bảng NGôn NGữ Sách
CREATE TABLE NgonNguSach(
    ID_NNS int IDENTITY(1,1) PRIMARY KEY Not null,
    ID_NN int not null,
    ID_Sach int not null,
    MaNNS as 'NNS' + cast(ID_NNS as nvarchar(5)) persisted,
    TrangThai int not null
    FOREIGN KEY (ID_NN) REFERENCES NgonNguSanPham(ID_NN),
	FOREIGN KEY (ID_Sach) REFERENCES Sach(ID_Sach)
)
-- Tạo Bảng Hình Thức Giao Dịch
CREATE TABLE HinhThucGiaoDich(
    ID_HTGD int IDENTITY(1,1) PRIMARY KEY Not null,
    ID_Hd int not null,
    ID_PTTT int not null,
    MaGD as 'HTGD' + cast(ID_HTGD as nvarchar(5)) persisted,
    TienThanhToan int not null,
    TrangThai int not null
    FOREIGN KEY (ID_Hd) REFERENCES HoaDon(ID_Hd),
	FOREIGN KEY (ID_PTTT) REFERENCES PhuongThucThanhToan(ID_PTTT)
)

-- Thêm dữ liệu vào bảng ChucVu
INSERT INTO ChucVu (TenCV, TrangThai) VALUES 
    (N'Quản lý', 1),
    (N'Nhân viên', 1),
    (N'Khách Hàng', 1);

-- Thêm dữ liệu vào bảng TaiKhoan
INSERT INTO TaiKhoan (ID_CV, TaiKhoan, MatKhau, Email, NgayTao, SDT, NgaySinh, DiaChi, TrangThai) VALUES 
    (1, 'admin', 'admin@123', 'admin@example.com', GETDATE(), '123456789', '1990-01-01', 'Hanoi', 1),
    (2, 'employee1', 'pass123', 'employee1@example.com', GETDATE(), '987654321', '1995-05-15', 'Ho Chi Minh', 1),
    (3, 'accountant1', 'pass456', 'accountant1@example.com', GETDATE(), '555555555', '1988-12-10', 'Da Nang', 1);

-- Thêm dữ liệu vào bảng TheLoai
INSERT INTO TheLoai (TenTL, Mota, TrangThai) VALUES 
    (N'Học thuật', N'Danh mục về học thuật', 1),
    (N'Giải trí', N'Danh mục về giải trí', 1),
    (N'Kinh doanh', N'Danh mục về kinh doanh', 1);

-- Thêm dữ liệu vào bảng TacGia
INSERT INTO TacGia (TenTG, NgaySinh, QuocTich, TrangThai) VALUES 
    ('Nguyen Van A', '1980-03-20', 'Vietnamese', 1),
    ('Tran Thi B', '1992-08-15', 'Vietnamese', 1),
    ('John Doe', '1975-05-01', 'American', 1);

-- Thêm dữ liệu vào bảng NhaXuatBan
INSERT INTO NhaXuatBan (TenNXB, DiaChiNXB, TrangThai) VALUES 
    (N'Nhà Xuất Bản A', N'123 Đường ABC, Quận 1, TP.HCM', 1),
    (N'Nhà Xuất Bản B', N'456 Đường XYZ, Quận 2, TP.HCM', 1),
    (N'Nhà Xuất Bản C', N'789 Đường LMN, Quận 3, TP.HCM', 1);

-- Thêm dữ liệu vào bảng KhuVucLuuTru
INSERT INTO KhuVucLuuTru (TenKV, TrangThai) VALUES 
    (N'Khu Vực A', 1),
    (N'Khu Vực B', 1),
    (N'Khu Vực C', 1);

-- Thêm dữ liệu vào bảng NgonNguSanPham
INSERT INTO NgonNguSanPham (TenNN, TrangThai) VALUES 
    (N'Tiếng Việt', 1),
    (N'English', 1),
    (N'Pháp', 1);

-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (TenKH, SDT, DiaChi, GioiTinh, NgayTao, TrangThai) VALUES 
    ('Nguyen Van Khach', '123456789', N'456 Đường QWE, Quận 4, TP.HCM', 1, GETDATE(), 1),
    ('Tran Thi Anh', '987654321', N'789 Đường ZXC, Quận 5, TP.HCM', 0, GETDATE(), 1),
    ('John Doe', '555555555', N'101 Đường ASD, Quận 6, TP.HCM', NULL, GETDATE(), 1);

-- Thêm dữ liệu vào bảng MaGiamGia
INSERT INTO MaGiamGia (Ma_GG, Mota, Giatri, NgayTao, NgayHetHan, SoLuong, DieuKien, TienGiamToiDa, TrangThai) VALUES 
    ('MG123', N'Giảm giá 20%', 20, GETDATE(), DATEADD(day, 30, GETDATE()), 100, 500000, 100000, 1),
    ('MG456', N'Giảm giá 30%', 30, GETDATE(), DATEADD(day, 45, GETDATE()), 50, 1000000, 150000, 1),
    ('MG789', N'Giảm giá 10%', 10, GETDATE(), DATEADD(day, 60, GETDATE()), 200, 200000, 50000, 1);

-- Thêm dữ liệu vào bảng HoaDon
INSERT INTO HoaDon (ID_TK, ID_Kh, TenNguoiMua, SDTNguoiMua, NgayTao, NgayThanhToan, TongTienGoc, TongTienSauGiamGia, TrangThai) VALUES 
    (2, 1, 'Nguyen Van A', '123456789', GETDATE(), GETDATE(), 1500000, 1200000, 1),
    (3, 2, 'Tran Thi B', '987654321', GETDATE(), GETDATE(), 2000000, 1600000, 1),
    (1, 3, 'John Doe', '555555555', GETDATE(), GETDATE(), 1000000, 900000, 1);

-- Thêm dữ liệu vào bảng MaGiamGiaHoaDon
INSERT INTO MaGiamGiaHoaDon (ID_Hd, ID_MGG, NgaySuDung, TrangThai) VALUES 
    (1, 1, GETDATE(), 1),
    (2, 2, GETDATE(), 1),
    (3, 3, GETDATE(), 1);

-- Thêm dữ liệu vào bảng Sach
INSERT INTO Sach (ID_KV, ID_NXB,ID_TG,ID_TL ,TenSach, NamSanXuat, SoLuongSanPham, GiaSanPham, SoTrang, MoTa, TrangThai) VALUES 
    (1, 1, 1,1,N'Sách 1', 2022, 100, 50000, 200, N'Sách mô tả về khoa học', 1),
    (2, 2,2,2,N'Sách 2', 2021, 50, 80000, 150, N'Sách mô tả về văn hóa', 1),
    (3, 3, 3,3,N'Sách 3', 2023, 200, 40000, 180, N'Sách mô tả về lịch sử', 1);

    -- Thêm dữ liệu vào bảng AnhSach
INSERT INTO AnhSach (id_Sach, TenAnh, TrangThai) VALUES 
    (1, 'anh_sach_1.jpg', 1),
    (2, 'anh_sach_2.jpg', 1),
    (3, 'anh_sach_3.jpg', 1);

-- Thêm dữ liệu vào bảng ChiTietHoaDon
INSERT INTO ChitietHoaDon (id_hd, ID_Sach, SoLuong, Gia, TrangThai) VALUES 
    (1, 1, 2, 100000, 1),
    (1, 2, 1, 150000, 1),
    (2, 3, 3, 80000, 1);


-- Thêm dữ liệu vào bảng PhuongThucThanhToan
INSERT INTO PhuongThucThanhToan (TenPT, TrangThai) VALUES 
    (N'Thanh toán khi nhận hàng', 1),
    (N'Thanh toán qua thẻ tín dụng', 1),
    (N'Chuyển khoản ngân hàng', 1);

-- Thêm dữ liệu vào bảng NgonNguSach
INSERT INTO NgonNguSach (ID_NN, ID_Sach	, TrangThai) VALUES 
    (1, 1, 1),
    (2, 2, 1),
    (3, 3, 1)
	--(1, 3, 1);

-- Thêm dữ liệu vào bảng HinhThucGiaoDich
INSERT INTO HinhThucGiaoDich (ID_Hd, ID_PTTT, TienThanhToan, TrangThai) VALUES 
    (1, 1, 1200000, 1),
    (2, 2, 1600000, 1),
    (3, 3, 900000, 1);
    
-- Truy vấn dữ liệu từ bảng ChucVu
SELECT * FROM ChucVu;

-- Truy vấn dữ liệu từ bảng TaiKhoan
SELECT * FROM TaiKhoan;

-- Truy vấn dữ liệu từ bảng TheLoai
SELECT * FROM TheLoai;

-- Truy vấn dữ liệu từ bảng TacGia
SELECT * FROM TacGia;

-- Truy vấn dữ liệu từ bảng NhaXuatBan
SELECT * FROM NhaXuatBan;

-- Truy vấn dữ liệu từ bảng KhuVucLuuTru
SELECT * FROM KhuVucLuuTru;

-- Truy vấn dữ liệu từ bảng NgonNguSanPham
SELECT * FROM NgonNguSanPham;

-- Truy vấn dữ liệu từ bảng KhachHang
SELECT * FROM KhachHang;

-- Truy vấn dữ liệu từ bảng MaGiamGia
SELECT * FROM MaGiamGia;

-- Truy vấn dữ liệu từ bảng HoaDon
SELECT * FROM HoaDon;

-- Truy vấn dữ liệu từ bảng MaGiamGiaHoaDon
SELECT * FROM MaGiamGiaHoaDon;

-- Truy vấn dữ liệu từ bảng Sach
SELECT * FROM Sach;

-- Truy vấn dữ liệu từ bảng AnhSach
SELECT * FROM AnhSach;

-- Truy vấn dữ liệu từ bảng ChitietHoaDon
SELECT * FROM ChitietHoaDon;


-- Truy vấn dữ liệu từ bảng PhuongThucThanhToan
SELECT * FROM PhuongThucThanhToan;

-- Truy vấn dữ liệu từ bảng NgonNguSach
SELECT * FROM NgonNguSach;

-- Truy vấn dữ liệu từ bảng HinhThucGiaoDich
SELECT * FROM HinhThucGiaoDich;

SELECT 
    Sach.Ma_SACH AS MaSach,
    Sach.TenSach AS TenSach,
    Sach.NamSanXuat AS NamXuatBan,
    Sach.SoLuongSanPham AS SoLuong,
    Sach.GiaSanPham AS Gia,
    Sach.SoTrang AS SoTrang,
    Sach.MoTa AS MoTa,
	NgonNguSanPham.TenNN,
	TheLoai.TenTL AS Theloai,
    NhaXuatBan.TenNXB AS NhaXuatBan,
    TacGia.TenTG,
    KhuVucLuuTru.TenKV AS KhuVucLuuTru,
    Sach.TrangThai AS TrangThai
FROM Sach
    INNER JOIN NgonNguSach ON Sach.ID_Sach = NgonNguSach.ID_Sach
    INNER JOIN NgonNguSanPham ON NgonNguSach.ID_NN = NgonNguSanPham.ID_NN
    INNER JOIN TheLoai ON Sach.ID_TL = TheLoai.ID_TL
    INNER JOIN NhaXuatBan ON Sach.ID_NXB = NhaXuatBan.ID_NXB
    INNER JOIN TacGia ON Sach.id_TG = TacGia.id_TG
    INNER JOIN KhuVucLuuTru ON Sach.ID_KV = KhuVucLuuTru.ID_KV

	