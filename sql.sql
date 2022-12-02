create table ChucVu(
	MaCV varchar(5) primary key,
	TenCV text
);

create table ChiNhanh(
    MaCN varchar(5) primary key,
    TenCN text,
    DiaChi text,
    SoDT varchar(10)
);
create table NhanVien(
	MaNV varchar(5) primary key,
	HoTen text,
	GioiTinh int,
	MatKhau varchar(10),
	NgaySinh DATe,
	SoDT varchar(10),
	MaCV varchar(5),
	CONSTRAINT fk_nv_cv FOREIGN key (MaCV) REFERENCES ChucVu (MaCV)
);
create table LichLamViec(
    ID_LLV serial primary key,
    NgayLam Date,
    ThoiGianBatDau time,
    ThoiGianKetThuc time,
    LuongCoBan float,
    MaNV varchar(5),
    MaCN varchar(5),
    CONSTRAINT fk_llv_nv FOREIGN key (MaNV) REFERENCES NhanVien (MaNV),
    CONSTRAINT fk_llv_cn FOREIGN key (MaCN) REFERENCES ChiNhanh (MaCN)
);
create table CSVC(
    MaCSVC varchar(5) primary key,
    TenCSVC text,
    Hinh text
);
create table KhachHang(
	MaKH serial primary key,
	TenKH text,
	MatKhau varchar(10),
	Email varchar(30) unique,
	SoDT varchar(10),
	DiaChi text,
	GioiTinh bit,
	IdFB text,
	HinhFB text
);

create table Topping(
	MaTopping varchar(5) primary key,
	TenTopping text,
	SoLuongDangCo int,
	Gia float,
	hinh text
);

create table LoaiGhe(
	MaLoai int primary key ,
	TenLoai text,
	PhuThu float
);

create table Ghe(
	MaGhe varchar(5) primary key,
	TenGhe varchar(5),
	MaLoai int,
	CONSTRAINT fk_ghe_loaighe foreign key (MaLoai) references LoaiGhe(MaLoai)
);

create table TheLoai(
	MaTheLoai varchar(5) primary key,
	TenTheLoai text
);

create table Phim(
	MaPhim varchar(5) primary key,
	TenPhim text,
	DienVien text,
	NamSX int,
	Hinh text,
	DaoDien text,
	QuocGia text,
	ThoiLuong text,
	MoTa text,
	Traller text
);

create table ChiTietPhim(
	MaPhim varchar(5),
	MaTheLoai varchar(5),
	primary key (MaPhim,MaTheLoai),
	constraint fk_ctphim_phim foreign key (MaPhim) references Phim(MaPhim) on delete cascade,
	constraint fk_ctphim_theloai foreign key (MaTheLoai) references TheLoai(MaTheLoai)
);

create table NgayChieu(
	Stt serial primary key,
	Ngay date,
	GioBatDau time
);
create table PhongChieu(
	MaPhong varchar(5) primary key,
	TenPhong text,
	MaCN varchar(5),
	constraint fk_pc_cn foreign key (MaCN) references ChiNhanh(MaCN)
);

create table ChiTietGhe (
	MaCTGhe int primary key,
	MaPhong varchar(5),
	MaGhe varchar(5),
	constraint fk_ctghe_phong foreign key (MaPhong) references PhongChieu(MaPhong),
	constraint fk_ctghe_ghe foreign key(MaGhe) references Ghe (MaGhe)
);
create table CT_CSVC(
    MaCSVC varchar(5),
    MaPhong varchar(5),
	SoLuong int,
    primary key (MaCSVC,MaPhong),
    constraint fk_ctcsvc_phong foreign key (MaPhong) references PhongChieu(MaPhong),
	constraint fk_ctcsvc_csvc foreign key(MaCSVC) references CSVC (MaCSVC)
);
create table XuatChieu(
	Stt serial primary key,
	GiaXuatChieu float,
	Ngay int,
	MaPhong varchar(5),
	MaPhim varchar(5),
	foreign key(Ngay) references NgayChieu(Stt),
	constraint fk_xuatchieu_phong foreign key(MaPhong) references PhongChieu(MaPhong),
constraint fk_xuatchieu_phim foreign key (MaPhim) references Phim(MaPhim) on delete cascade
);

create table Ve(
	IdVe serial primary key,
	TongGiaVe float,
	ThueVAT float,
	MaKH int,
	MaCTGhe int,
	Stt_XC int,
	constraint fk_ve_khachhang foreign key (MaKH) references KhachHang(MaKH) on delete cascade,
	constraint fk_ve_ctghe foreign key(MaCTGhe) references ChiTietGhe(MaCTGhe)
);

create table ChiTietTopping(
	IdVe int,
	MaTopping varchar(5),
	SoLuongMua int,
	primary key(IdVe,MaTopping),
	constraint fk_ctTopping_Topping foreign key(MaTopping) references Topping(MaTopping) on delete cascade,
	constraint fk_ctTopping_Ve foreign key(IdVe) references Ve(IdVe) on delete cascade
);
insert into ChiNhanh values('cn1','Hưng Thịnh','78, Bình Hưng Hòa, quận Bình Thạnh','012345678');
insert into ChiNhanh values('cn2','Bình Tân','90, Phạm Ngũ Lão, quận Bình Tân','012345679');
insert into ChiNhanh values('cn3','Tân Phú','178, Lý Thường Kiệt, quận Tân Phú','012345680');
insert into ChiNhanh values('cn4','Cộng Hòa','60, Cộng Hòa, quận Tân Bình','012345681');
insert into ChiNhanh values('cn5','Quang Trung','199, Quang Trung, quận Gò Vấp','012345682');

insert into CSVC values('vc1','Máy chiếu','vc1.png');
insert into CSVC values('vc2','Camera','vc2.png');
insert into CSVC values('vc3','Máy lạnh','vc3.png');
insert into CSVC values('vc4','Cảm biến báo khói ','vc4.png');
insert into CSVC values('vc5','Bình xịt chữa cháy','vc5.png');


insert into KHACHHANG values('1',N'Mai Thị Hồng Ngân','12345678','Ngan@gmail.com','0165538970',N'20 Lê Duẩn, Quận Gò Vấp','0', null, null);
insert into KHACHHANG values('2',N'Phạm Thị Trà','12345678','Tra@gmail.com','0962345623',N'56 Nguyễn Văn Nghi, Quận 4','0', null, null);
insert into KHACHHANG values('3',N'Trần Thị Trường An','12345678','An@gmail.com','0934179463',N'26B Tân Phú, Quận Tân Bình','0', null, null);
insert into KHACHHANG values('4',N'Ngô Hồng Trinh','12345678','Trinh@gmail.com','0934179464',N'12/34 Nguyễn Oanh, Quận Gò Vấp','0', null, null);
insert into KHACHHANG values('5',N'Nguyễn Thị Thu Thảo','12345678','Thao@gmail.com','0934179465',N'01 Lý Thường Kiệt, Quận 12','0', null, null);
insert into KHACHHANG values('6',N'Đào Khải Minh','12345678','Minh@gmail.com','0934179466',N'125 Lê Hồng Thái, Quận 8','1', null, null);
insert into KHACHHANG values('7',N'Nguyễn Thị Ngọc Hân','12345678','Han@gmail.com','0934179467',N'27A Lê Thái Sơn, Quận 1','0', null, null);
insert into KHACHHANG values('8',N'Nguyễn Sơn Trung Kiên','12345678','Kien@gmail.com','0934179468',N'13/34 Quang Trung, Quận 3','1', null, null);
insert into KHACHHANG values('9',N'Bàng Thanh Sơn','12345678','Son@gmail.com','0934179469',N'60 Phan Văn Trị, Quận Tân Bình','1', null, null);
insert into KHACHHANG values('10',N'Hồ Hoàng Khang','12345678','Khang@gmail.com','0934179470',N'46/12 Hà Huy Hùng, Quận 9','1', null, null);
insert into KHACHHANG values('11',N'Trương Thị Kim Ngân','12345678','Ngan11@gmail.com','0934179471',N'Đông Hưng Thuận, Thủ Đức','0', null, null);
insert into KHACHHANG values('12',N'Phạm Ngọc Khách Đoan','12345678','Doan@gmail.com','0934179472',N'Lạc Long Quân, Quận Tân Bình','0', null, null);
insert into KHACHHANG values('13',N'Nguyễn Thị Kim Tuyền','12345678','Tuyen@gmail.com','0934179473',N'Nguyễn Văn Trỗi, Phú Nhuận','0', null, null);
insert into KHACHHANG values('14',N'Phạm Ngọc Kim Ngân','12345678','Ngan12@gmail.com','0934179474',N'chợ Cây Gõ, Quận 6','0', null, null);
insert into KHACHHANG values('15',N'Trần Quốc Đại','12345678','Dai@gmail.com','0934179475',N'Trần Hưng Đạo, Quận 5','1', null, null);

insert into ChucVu values('CV1','Trưởng bộ phận');
insert into ChucVu values('CV2','Nhân viên');

insert into NHANVIEN values('NV01',N'Đồng Quốc Tiến',1,'11111111','1992-07-10','0123456778','CV1');
insert into NHANVIEN values('NV02',N'Huỳnh Thị Anh Thúy',0,'22222222','1991-02-11','0999993456','CV2');
insert into NHANVIEN values('NV03',N'Nguyễn Ngọc Giang',0,'11111111','1995-01-01','0132667889','CV1');
insert into NHANVIEN values('NV04',N'Trần Quốc Tiến',1,'11111111','1993-09-09','0945576843','CV1');
insert into NHANVIEN values('NV05',N'Lương Thế Thành',1,'22222222','1996-11-01','0138463845','CV2');
insert into NHANVIEN values('NV06',N'Nguyễn Minh Ngọc',0,'22222222','1999-12-12','0947635726','CV2');
insert into NHANVIEN values('NV07',N'Lưu Hoàng Thạnh',1,'22222222','1998-03-28','0184736346','CV2');
insert into NHANVIEN values('NV08',N'Nguyễn Thị Thùy Dương',0,'11111111','1997-04-03','0974626397','CV1');
insert into NHANVIEN values('NV09',N'Phạm Minh Quốc',1,'11111111','2000-06-15','0173843888','CV1');
insert into NHANVIEN values('NV10',N'Trần Hải Dăng',1,'22222222','2001-07-09','0974364525','CV2');
insert into NHANVIEN values('NV11',N'Nguyễn Ngọc Diễm Châu',0,'11111111','1997-08-08','0926424685','CV1');
insert into NHANVIEN values('NV12',N'Trần Thị Linh Nhi',0,'11111111','2002-07-06','0942518377','CV1');
insert into NHANVIEN values('NV13',N'Hồ Hoàng Kha',1,'11111111','1999-05-04','0943826822','CV1');
insert into NHANVIEN values('NV14',N'Nguyễn Minh Mẫn',1,'22222222','2000-05-03','0193746384','CV2');
insert into NHANVIEN values('NV15',N'Nguyễn Thị Ngọc Diệp',0,'11111111','2000-06-04','0947364282','CV1');

insert into LoaiGhe values(1,'Thường',0);
insert into LoaiGhe values(2,'Đôi',10000);
insert into LoaiGhe values(3,'Vip',15000);

insert into Ghe values('g1','A1',1);
insert into Ghe values('g2','A2',1);
insert into Ghe values('g3','A3',1);
insert into Ghe values('g4','A4',1);
insert into Ghe values('g5','A5',1);
insert into Ghe values('g6','A6',1);
insert into Ghe values('g7','A7',1);
insert into Ghe values('g8','A8',1);
insert into Ghe values('g9','A9',1);
insert into Ghe values('g10','A10',1);
insert into Ghe values('g11','A11',1);
insert into Ghe values('g12','A12',1);
insert into Ghe values('g13','B1',1);
insert into Ghe values('g14','B2',1);
insert into Ghe values('g15','B3',1);
insert into Ghe values('g16','B4',1);
insert into Ghe values('g17','B5',1);
insert into Ghe values('g18','B6',1);
insert into Ghe values('g19','B7',1);
insert into Ghe values('g20','B8',1);
insert into Ghe values('g21','B9',1);
insert into Ghe values('g22','B10',1);
insert into Ghe values('g23','B11',1);
insert into Ghe values('g24','B12',1);
insert into Ghe values('g25','C1',1);
insert into Ghe values('g26','C2',1);
insert into Ghe values('g27','C3',1);
insert into Ghe values('g28','C4',1);
insert into Ghe values('g29','C5',1);
insert into Ghe values('g30','C6',1);
insert into Ghe values('g31','C7',1);
insert into Ghe values('g32','C8',1);
insert into Ghe values('g33','C9',1);
insert into Ghe values('g34','C10',1);
insert into Ghe values('g35','C11',1);
insert into Ghe values('g36','C12',1);
insert into Ghe values('g37','D1',1);
insert into Ghe values('g38','D2',1);
insert into Ghe values('g39','D3',1);
insert into Ghe values('g40','D4',1);
insert into Ghe values('g41','D5',1);
insert into Ghe values('g42','D6',1);
insert into Ghe values('g43','D7',1);
insert into Ghe values('g44','D8',1);
insert into Ghe values('g45','D9',1);
insert into Ghe values('g46','D10',1);
insert into Ghe values('g47','D11',1);
insert into Ghe values('g48','D12',1);
insert into Ghe values('g49','E1',2);
insert into Ghe values('g50','E2',2);
insert into Ghe values('g51','E3',2);
insert into Ghe values('g52','E4',2);
insert into Ghe values('g53','E5',2);
insert into Ghe values('g54','E6',2);
insert into Ghe values('g55','E7',2);
insert into Ghe values('g56','E8',2);
insert into Ghe values('g57','E9',2);
insert into Ghe values('g58','E10',2);
insert into Ghe values('g59','E11',2);
insert into Ghe values('g60','E12',2);
insert into Ghe values('g61','F1',2);
insert into Ghe values('g62','F2',2);
insert into Ghe values('g63','F3',2);
insert into Ghe values('g64','F4',2);
insert into Ghe values('g65','F5',2);
insert into Ghe values('g66','F6',2);
insert into Ghe values('g67','F7',2);
insert into Ghe values('g68','F8',2);
insert into Ghe values('g69','F9',2);
insert into Ghe values('g70','F10',2);
insert into Ghe values('g71','F11',2);
insert into Ghe values('g72','F12',2);
insert into Ghe values('g73','G1',2);
insert into Ghe values('g74','G2',2);
insert into Ghe values('g75','G3',2);
insert into Ghe values('g76','G4',2);
insert into Ghe values('g77','G5',2);
insert into Ghe values('g78','G6',2);
insert into Ghe values('g79','G7',2);
insert into Ghe values('g80','G8',2);
insert into Ghe values('g81','G9',2);
insert into Ghe values('g82','G10',2);
insert into Ghe values('g83','G11',2);
insert into Ghe values('g84','G12',2);
insert into Ghe values('g85','H1',2);
insert into Ghe values('g86','H2',2);
insert into Ghe values('g87','H3',2);
insert into Ghe values('g88','H4',2);
insert into Ghe values('g89','H5',2);
insert into Ghe values('g90','H6',2);
insert into Ghe values('g91','H7',2);
insert into Ghe values('g92','H8',2);
insert into Ghe values('g93','H9',2);
insert into Ghe values('g94','H10',2);
insert into Ghe values('g95','H11',2);
insert into Ghe values('g96','H12',2);
insert into Ghe values('g97','J1',3);
insert into Ghe values('g98','J2',3);
insert into Ghe values('g99','J3',3);
insert into Ghe values('g100','J4',3);
insert into Ghe values('g101','J5',3);
insert into Ghe values('g102','J6',3);
insert into Ghe values('g103','J7',3);
insert into Ghe values('g104','J8',3);
insert into Ghe values('g105','J9',3);
insert into Ghe values('g106','J10',3);
insert into Ghe values('g107','J11',3);
insert into Ghe values('g108','J12',3);
insert into Ghe values('g109','J13',3);
insert into Ghe values('g110','J14',3);

insert into NgayChieu(ngay,giobatdau) values('2022-11-16','13:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-16','14:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-16','15:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-16','16:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-16','17:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-16','18:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-16','19:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-16','20:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-16','21:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-16','22:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-16','23:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-17','13:30:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-17','14:30:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-17','15:30:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-17','16:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-17','17:45:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-17','18:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-17','19:30:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-17','20:15:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-17','21:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-17','22:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-17','23:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-18','13:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-18','14:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-18','15:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-18','16:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-18','17:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-18','18:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-18','19:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-18','20:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-18','21:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-18','22:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-18','23:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-19','13:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-19','14:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-19','15:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-19','16:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-19','17:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-19','18:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-19','19:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-19','20:00:00');
insert into NgayChieu(ngay,giobatdau) values('2022-11-19','21:00:00');


insert into THELOAI values ('LP01','Hành động');
insert into THELOAI values ('LP02','Hài');
insert into THELOAI values ('LP03','Hoạt hình');
insert into THELOAI values ('LP04','Tình cảm');
insert into THELOAI values ('LP05','Kinh dị');

insert into phim values('MP01','QUÁI VẬT SÔNG MEKONG','Vithaya Pansringarm, Sushar Manaying, Teerapat Satjakul',2022,'MP01.png','Lee Thongkham','Thái Lan','105 phút','Một con quái vật bí ẩn bỗng xuất hiện từ sông Mekong và tấn công vùng Bueng Kan, nó hủy diệt mọi thứ và khiến người dân mất kết nối hoàn toàn với thế giới bên ngoài. Sự kiện gây chấn động toàn Thái Lan này đã khiến các cơ quan chức năng cùng những nhà khoa học vô tình đến Bueng Kan đã tiến hành nghiên cứu phải huy động tất cả các lực lượng để bắt con quái vật điên rồ này trước khi quá muộn','https://www.youtube.com/watch?v=orcxSddIA4s');
insert into phim values('MP02','NGƯỢC DÒNG THỜI GIAN ĐỂ YÊU ANH','Adisorn Tresirikasem',2022,'MP02.png','Ranee Campen, Thanavat Vatthanaputi','Thái Lan','166 phút','Gayasorn(Ranee Campen) - tiểu thư sống ở thời Rattanakosin chính là kiếp sau của Karaket ở triều đại Ayutthaya. Có lẽ bởi vậy mà Gaysorn đã chiếm trọn trái tim của Bhop(Thanavat Vatthanaputi) - cũng là hậu duệ của Dej - ngay từ lần đầu gặp mặt . Chàng kỹ sư tài năng đã luôn mơ về một cô con gái có gương mặt giống Gaysorn trong suốt 10 năm qua, và nghĩ rằng cô chính là tri kỉ mà mình đang tìm kiếm','https://www.youtube.com/watch?v=Whjb2Dj3nbc');
insert into phim values('MP03','BỘ TỨ DỊ GIỚI: THẾ GIỚI SONG SONG','Aoi Yuki, Sora Amamiya',2022,'MP03.png','Minoru Ashina','Nhật Bản','111 phút','Một ngày nọ, một nút bấm ma thuật đột nhiên xuất hiện. Sự kiện này là căn nguyên tạo nên sự giao thoa giữa nhóm các nhân vật chính của Bộ Tứ Dị Giới đến từ sáu loại light novel nổi tiếng gồm KonoSuba, Overlord, Re:Zero - Starting Life in Another World, và Saga of Tanya the Evil khi tất cả đồng thời cùng ấn nút và di chuyển đến thế giới song song - một Isekai hoàn toàn mới với câu chuyện mới được mở ra trong bối cảnh cuộc sống tại trường trung học. Isekai mới này được cai trị bởi một một con golem mất kiểm soát. Họ chạm trán một nữ yêu tinh có tính cách tương tự Megumin, một người đàn ông cầm gậy có vẻ như quen biết với Subaru và một người phụ nữ mặc trang phục giống Tanya. Tất cả phải cố gắng trở lại thế giới của mình','https://www.youtube.com/watch?v=sKQdlX-EWNY');
insert into phim values('MP04','NÔ LỆ CỦA QUỶ 2','Tara Basro, Endy Arfian, Bront Palarae',2022,'MP04.png','Joko Anwar','Indonesia','119 phút','Những sự kiện kinh hoàng xảy ra trong một chung cư cũ dần hé mở bí ẩn tâm linh từ quá khứ khi một gia đình thực hiện giao ước với quỷ','https://www.facebook.com/cgvcinemavietnam/videos/-hot-n%C3%B4-l%E1%BB%87-c%E1%BB%A7a-qu%E1%BB%B7-2-s%E1%BA%BD-l%C3%AAn-s%C3%B3ng-traier-c%E1%BB%B...9115/');
insert into phim values('MP05','MÔN PHÁI VÕ MÈO: HUYỀN THOẠI MỘT CHÚ CHÓ','Michael Cera, Samuel L.Jackson, Ricky Gervais, Kylie Kuioka, Michelle Yeoh',2022,'MP05.png','Mark Koetsier, Rob Minkoff','Mĩ','97 phút','Hank là chú chó đáng yêu có ước mơ trở thành một samurai vĩ đại. Trên con đường đi tìm định mệnh, Hank vô tình lạc vào một thị trấn đầy mèo. Và mèo thì không hề thích chó. Cũng vì mong muốn giành được tình cảm của cư dân thị trấn, Hank vô tình mắc vào âm mưu thôn tính thị trấn của tay mèo phản diện Ika Chu. Ika Chu đã từng lừa Hank giúp hắn đuổi các cư dân mèo ra khỏi thị trấn. Cùng với những người bạn mới quen, Hank phải tìm cách ngăn chặn âm mưu của Ika Chu và chuộc lại sai lầm của mình','https://www.youtube.com/watch?v=sPwFsXmvwAI');
insert into phim values('MP06','HẠ CÁNH KHẨN CẤP','Lee Byung Hun, Song Kang Ho, Joen Do Yoen, Im Si Wan, Kim Nam Gil',2022,'MP06.png','Han Jae Rim','Hàn Quốc','141 phút','Bộ phim xoay quanh chuyến bay kinh hoàng mang số hiệu KI501 của hãng hàng không Sky Korea từ sân bay quốc tế Incheon đến Honolulu, Hawaii. Bất ngờ, virus lạ tấn công các hàng khách trên máy bay rồi khiến họ liên tục ngứa ngáy, nôn ra máu và tử vong trong đau đớn. Một tuyên bố yêu cầu hạ cách khẩn cấp được đưa ra trong bối cảnh tất cả lâm vào trạng thái hoảng loạn tột độ. Trên độ cao 8,534 mét, số phận 150 con người sẽ ra sao trước loại virus tử thần ?','https://www.youtube.com/watch?v=CaIYD369OJI');
insert into phim values('MP07','CÙ LAO XÁC SỐNG','Huỳnh Đông, Ốc Thanh Vân, Trần Phong',2022,'MP07.png','Nguyễn Thành Nam','Việt Nam','93 phút','Phim nói về hành trình của Công - một thầy thuốc đông y cố gắng đưa cha và con gái thoát khỏi sự truy đuổi của xác sống khi đại dịch bùng nổ. Họ thất lạc nhau trên đường chạy trốn. Trong lúc tìm lại con gái, Công gặp những người bụ nạn khác giống mình. Họ cùng nhau hợp sức thành một nhóm, cố gắng vượt qua thử thách sống còn. Liệu kết quả sẽ ra sao khi đại dịch càng ngày càng lan rộng','https://www.youtube.com/watch?v=fCi9o3iieJU');
insert into phim values('MP08','KISAGARI: NHÀ GA NUỐT CHỬNG','Haruna Tsunematsu, Junko Hayama',2022,'MP08.png','Jiro Nagae','Nhât Bản','82 phút','Haruta Tsunematsu đang học nghiên cứu chuyên ngành văn hóa dân gian tại đại học. Cô quyết định lựa chọn truyền thuyết đô thị nổi tiếng là "Nhà ga Kisagari" để làm luận văn tốt nghiệp. Đây là câu chuyện rùng rợn từng được lưu truyền và khuấy đảo cộng đồng mạng vào năm 2004. Trong suốt quá trình thu thập tài liệu, Haruma gặp một người phị nữ có tên là Junko Hayama. Nhiều lời đồn rằng, Junko chính là người đã đăng câu chuyện trên lên mạng với tên gọi "Hasumi". Junko kể cho Haruna rằng cô đã lưu lạc tới một thế giới khác, và điều đó đã dẫn Haruna tới ga tàu Kisaragi - khởi nguồn của truyền thuyết đô thị năm xưa...','https://www.youtube.com/watch?v=sjYGMwVmFW0');
insert into phim values('MP09','TRUY SÁT TẬN CUNG','Ron Perlman, Karla Souza, José María Yazpik, Tim Roth, Shannyn Sossamon, Paz Vega',2022,'MP09.png','Alfonso Pineda Ulloa','Tây Ban Nha','99 phút','Một người đàn ông bị kết án vì một tội ác mà anh ta không phạm phải. Khi vợ anh bị sát hại và con trai anh bị bắt cóc và đưa đến Mexico, anh nghĩ ra một kế hoạch phức tạp và vô cùng nguy hiểm để giải cứu con trai mình và trả thù cho người đã sát hại vợ anh','https://www.youtube.com/watch?v=VSbAM_frv2s');
insert into phim values('MP10','GIỚI HẠN TRUY LÙNG','Lee Jung Hyun, Moon Jung Hee, Jin Seo Jun, Park Myung Hoon, Choi Deok Moon,Park Kyung Hye',2022,'MP10.png','Lee Seung Joon','Hàn Quốc','87 phút','Hành trình truy đuổi bọn bắt cóc của một nữ cảnh sát đóng giả mẹ của một nạn nhân khiến chính con trai cô cũng bị đặt vào vòng nguy hiểm, khi thân phận của cô có khả năng bị bại lộ. Giới Hạn Truy Lùng không chỉ mang đến nhuengx màn rượt đuổi hồi hộp, các pha hành động mãn nhãn, mà còn là cuộc đấu trí đầy gây cấn giữa hai phe chính - tà','https://www.youtube.com/watch?v=r00k3E9oOEk');
insert into phim values('MP11','IVANNA','Caitlin Halderman, Sonia Alyssa, Jovarel Callum, Junior Roberts, Shandy William',2022,'MP11.png','Kimo Stamboel','Indonesia','103 phút','Ambar - một cô gái sở hữu đôi mắt âm dương cùng người em Dika đến ở tại một viện dưỡng lão. Tại đây, họ đã phát hiện ra sự thật kinh hoàng về hồn ma không đầu Ivanna và một phần lịch sử thảm khóc của nước nhà','https://www.youtube.com/watch?v=i54sZ1O-vPc');

insert into CHITIETPHIM values ('MP01','LP01');
insert into CHITIETPHIM values ('MP01','LP04');		
insert into CHITIETPHIM values ('MP02','LP04');		
insert into CHITIETPHIM values ('MP02','LP03');		
insert into CHITIETPHIM values ('MP03','LP05');		
insert into CHITIETPHIM values ('MP03','LP03');		
insert into CHITIETPHIM values ('MP04','LP01');		
insert into CHITIETPHIM values ('MP04','LP05');		
insert into CHITIETPHIM values ('MP05','LP05');		
insert into CHITIETPHIM values ('MP05','LP02');		
insert into CHITIETPHIM values ('MP06','LP02');		
insert into CHITIETPHIM values ('MP06','LP04');		
insert into CHITIETPHIM values ('MP07','LP03');		
insert into CHITIETPHIM values ('MP07','LP01');		
insert into CHITIETPHIM values ('MP08','LP02');		
insert into CHITIETPHIM values ('MP08','LP03');		
insert into CHITIETPHIM values ('MP09','LP05');		
insert into CHITIETPHIM values ('MP09','LP04');		
insert into CHITIETPHIM values ('MP10','LP03');		
insert into CHITIETPHIM values ('MP10','LP02');		

insert into PHONGCHIEU values('PC01','Phòng 1','cn1');
insert into PHONGCHIEU values('PC02','Phòng 2','cn1');
insert into PHONGCHIEU values('PC03','Phòng 3','cn1');
insert into PHONGCHIEU values('PC04','Phòng 4','cn1');
insert into PHONGCHIEU values('PC05','Phòng 5','cn1');
insert into PHONGCHIEU values('PC06','Phòng 6','cn1');
insert into PHONGCHIEU values('PC07','Phòng 7','cn1');
insert into PHONGCHIEU values('PC08','Phòng 8','cn1');
insert into PHONGCHIEU values('PC09','Phòng 9','cn1');
insert into PHONGCHIEU values('PC10','Phòng 10','cn1');
insert into PHONGCHIEU values('PC11','Phòng 1','cn2');
insert into PHONGCHIEU values('PC12','Phòng 2','cn2');
insert into PHONGCHIEU values('PC13','Phòng 3','cn2');
insert into PHONGCHIEU values('PC14','Phòng 4','cn2');
insert into PHONGCHIEU values('PC15','Phòng 5','cn2');
insert into PHONGCHIEU values('PC16','Phòng 6','cn2');
insert into PHONGCHIEU values('PC17','Phòng 7','cn2');
insert into PHONGCHIEU values('PC18','Phòng 8','cn2');
insert into PHONGCHIEU values('PC19','Phòng 9','cn2');
insert into PHONGCHIEU values('PC20','Phòng 10','cn2');
insert into PHONGCHIEU values('PC21','Phòng 1','cn3');
insert into PHONGCHIEU values('PC22','Phòng 2','cn3');
insert into PHONGCHIEU values('PC23','Phòng 3','cn3');
insert into PHONGCHIEU values('PC24','Phòng 4','cn3');
insert into PHONGCHIEU values('PC25','Phòng 5','cn3');
insert into PHONGCHIEU values('PC26','Phòng 6','cn3');
insert into PHONGCHIEU values('PC27','Phòng 7','cn3');
insert into PHONGCHIEU values('PC28','Phòng 8','cn3');
insert into PHONGCHIEU values('PC29','Phòng 9','cn3');
insert into PHONGCHIEU values('PC30','Phòng 10','cn3');
insert into PHONGCHIEU values('PC31','Phòng 1','cn4');
insert into PHONGCHIEU values('PC32','Phòng 2','cn4');
insert into PHONGCHIEU values('PC33','Phòng 3','cn4');
insert into PHONGCHIEU values('PC34','Phòng 4','cn4');
insert into PHONGCHIEU values('PC35','Phòng 5','cn4');
insert into PHONGCHIEU values('PC36','Phòng 6','cn4');
insert into PHONGCHIEU values('PC37','Phòng 7','cn4');
insert into PHONGCHIEU values('PC38','Phòng 8','cn4');
insert into PHONGCHIEU values('PC39','Phòng 9','cn4');
insert into PHONGCHIEU values('PC40','Phòng 10','cn4');
insert into PHONGCHIEU values('PC41','Phòng 1','cn5');
insert into PHONGCHIEU values('PC42','Phòng 2','cn5');
insert into PHONGCHIEU values('PC43','Phòng 3','cn5');
insert into PHONGCHIEU values('PC44','Phòng 4','cn5');
insert into PHONGCHIEU values('PC45','Phòng 5','cn5');
insert into PHONGCHIEU values('PC46','Phòng 6','cn5');
insert into PHONGCHIEU values('PC47','Phòng 7','cn5');
insert into PHONGCHIEU values('PC48','Phòng 8','cn5');
insert into PHONGCHIEU values('PC49','Phòng 9','cn5');
insert into PHONGCHIEU values('PC50','Phòng 10','cn5');

insert into CT_CSVC values('vc1','PC01',1);
insert into CT_CSVC values('vc2','PC01',6);
insert into CT_CSVC values('vc3','PC01',2);
insert into CT_CSVC values('vc4','PC01',1);
insert into CT_CSVC values('vc5','PC01',1);
insert into CT_CSVC values('vc1','PC02',1);
insert into CT_CSVC values('vc2','PC02',6);
insert into CT_CSVC values('vc3','PC02',2);
insert into CT_CSVC values('vc4','PC02',1);
insert into CT_CSVC values('vc5','PC02',1);
insert into CT_CSVC values('vc1','PC03',1);
insert into CT_CSVC values('vc2','PC03',6);
insert into CT_CSVC values('vc3','PC03',2);
insert into CT_CSVC values('vc4','PC03',1);
insert into CT_CSVC values('vc5','PC03',1);
insert into CT_CSVC values('vc1','PC04',1);
insert into CT_CSVC values('vc2','PC04',6);
insert into CT_CSVC values('vc3','PC04',2);
insert into CT_CSVC values('vc4','PC04',1);
insert into CT_CSVC values('vc5','PC04',1);
insert into CT_CSVC values('vc1','PC05',1);
insert into CT_CSVC values('vc2','PC05',6);
insert into CT_CSVC values('vc3','PC05',2);
insert into CT_CSVC values('vc4','PC05',1);
insert into CT_CSVC values('vc5','PC05',1);
insert into CT_CSVC values('vc1','PC06',1);
insert into CT_CSVC values('vc2','PC06',6);
insert into CT_CSVC values('vc3','PC06',2);
insert into CT_CSVC values('vc4','PC06',1);
insert into CT_CSVC values('vc5','PC06',1);
insert into CT_CSVC values('vc1','PC07',1);
insert into CT_CSVC values('vc2','PC07',6);
insert into CT_CSVC values('vc3','PC07',2);
insert into CT_CSVC values('vc4','PC07',1);
insert into CT_CSVC values('vc5','PC07',1);
insert into CT_CSVC values('vc1','PC08',1);
insert into CT_CSVC values('vc2','PC08',6);
insert into CT_CSVC values('vc3','PC08',2);
insert into CT_CSVC values('vc4','PC08',1);
insert into CT_CSVC values('vc5','PC08',1);
insert into CT_CSVC values('vc1','PC09',1);
insert into CT_CSVC values('vc2','PC09',6);
insert into CT_CSVC values('vc3','PC09',2);
insert into CT_CSVC values('vc4','PC09',1);
insert into CT_CSVC values('vc5','PC09',1);
insert into CT_CSVC values('vc1','PC10',1);
insert into CT_CSVC values('vc2','PC10',6);
insert into CT_CSVC values('vc3','PC10',2);
insert into CT_CSVC values('vc4','PC10',1);
insert into CT_CSVC values('vc5','PC10',1);
insert into CT_CSVC values('vc1','PC11',1);
insert into CT_CSVC values('vc2','PC11',6);
insert into CT_CSVC values('vc3','PC11',2);
insert into CT_CSVC values('vc4','PC11',1);
insert into CT_CSVC values('vc5','PC11',1);
insert into CT_CSVC values('vc1','PC12',1);
insert into CT_CSVC values('vc2','PC12',6);
insert into CT_CSVC values('vc3','PC12',2);
insert into CT_CSVC values('vc4','PC12',1);
insert into CT_CSVC values('vc5','PC12',1);
insert into CT_CSVC values('vc1','PC13',1);
insert into CT_CSVC values('vc2','PC13',6);
insert into CT_CSVC values('vc3','PC13',2);
insert into CT_CSVC values('vc4','PC13',1);
insert into CT_CSVC values('vc5','PC13',1);
insert into CT_CSVC values('vc1','PC14',1);
insert into CT_CSVC values('vc2','PC14',6);
insert into CT_CSVC values('vc3','PC14',2);
insert into CT_CSVC values('vc4','PC14',1);
insert into CT_CSVC values('vc5','PC14',1);
insert into CT_CSVC values('vc1','PC15',1);
insert into CT_CSVC values('vc2','PC15',6);
insert into CT_CSVC values('vc3','PC15',2);
insert into CT_CSVC values('vc4','PC15',1);
insert into CT_CSVC values('vc5','PC15',1);
insert into CT_CSVC values('vc1','PC16',1);
insert into CT_CSVC values('vc2','PC16',6);
insert into CT_CSVC values('vc3','PC16',2);
insert into CT_CSVC values('vc4','PC16',1);
insert into CT_CSVC values('vc5','PC16',1);
insert into CT_CSVC values('vc1','PC17',1);
insert into CT_CSVC values('vc2','PC17',6);
insert into CT_CSVC values('vc3','PC17',2);
insert into CT_CSVC values('vc4','PC17',1);
insert into CT_CSVC values('vc5','PC17',1);
insert into CT_CSVC values('vc1','PC18',1);
insert into CT_CSVC values('vc2','PC18',6);
insert into CT_CSVC values('vc3','PC18',2);
insert into CT_CSVC values('vc4','PC18',1);
insert into CT_CSVC values('vc5','PC18',1);
insert into CT_CSVC values('vc1','PC19',1);
insert into CT_CSVC values('vc2','PC19',6);
insert into CT_CSVC values('vc3','PC19',2);
insert into CT_CSVC values('vc4','PC19',1);
insert into CT_CSVC values('vc5','PC19',1);
insert into CT_CSVC values('vc1','PC20',1);
insert into CT_CSVC values('vc2','PC20',6);
insert into CT_CSVC values('vc3','PC20',2);
insert into CT_CSVC values('vc4','PC20',1);
insert into CT_CSVC values('vc5','PC20',1);
insert into CT_CSVC values('vc1','PC21',1);
insert into CT_CSVC values('vc2','PC21',6);
insert into CT_CSVC values('vc3','PC21',2);
insert into CT_CSVC values('vc4','PC21',1);
insert into CT_CSVC values('vc5','PC21',1);
insert into CT_CSVC values('vc1','PC22',1);
insert into CT_CSVC values('vc2','PC22',6);
insert into CT_CSVC values('vc3','PC22',2);
insert into CT_CSVC values('vc4','PC22',1);
insert into CT_CSVC values('vc5','PC22',1);
insert into CT_CSVC values('vc1','PC23',1);
insert into CT_CSVC values('vc2','PC23',6);
insert into CT_CSVC values('vc3','PC23',2);
insert into CT_CSVC values('vc4','PC23',1);
insert into CT_CSVC values('vc5','PC23',1);
insert into CT_CSVC values('vc1','PC24',1);
insert into CT_CSVC values('vc2','PC24',6);
insert into CT_CSVC values('vc3','PC24',2);
insert into CT_CSVC values('vc4','PC24',1);
insert into CT_CSVC values('vc5','PC24',1);
insert into CT_CSVC values('vc1','PC25',1);
insert into CT_CSVC values('vc2','PC25',6);
insert into CT_CSVC values('vc3','PC25',2);
insert into CT_CSVC values('vc4','PC25',1);
insert into CT_CSVC values('vc5','PC25',1);
insert into CT_CSVC values('vc1','PC26',1);
insert into CT_CSVC values('vc2','PC26',6);
insert into CT_CSVC values('vc3','PC26',2);
insert into CT_CSVC values('vc4','PC26',1);
insert into CT_CSVC values('vc5','PC26',1);
insert into CT_CSVC values('vc1','PC27',1);
insert into CT_CSVC values('vc2','PC27',6);
insert into CT_CSVC values('vc3','PC27',2);
insert into CT_CSVC values('vc4','PC27',1);
insert into CT_CSVC values('vc5','PC27',1);
insert into CT_CSVC values('vc1','PC28',1);
insert into CT_CSVC values('vc2','PC28',6);
insert into CT_CSVC values('vc3','PC28',2);
insert into CT_CSVC values('vc4','PC28',1);
insert into CT_CSVC values('vc5','PC28',1);
insert into CT_CSVC values('vc1','PC29',1);
insert into CT_CSVC values('vc2','PC29',6);
insert into CT_CSVC values('vc3','PC29',2);
insert into CT_CSVC values('vc4','PC29',1);
insert into CT_CSVC values('vc5','PC29',1);
insert into CT_CSVC values('vc1','PC30',1);
insert into CT_CSVC values('vc2','PC30',6);
insert into CT_CSVC values('vc3','PC30',2);
insert into CT_CSVC values('vc4','PC30',1);
insert into CT_CSVC values('vc5','PC30',1);
insert into CT_CSVC values('vc1','PC31',1);
insert into CT_CSVC values('vc2','PC31',6);
insert into CT_CSVC values('vc3','PC31',2);
insert into CT_CSVC values('vc4','PC31',1);
insert into CT_CSVC values('vc5','PC31',1);
insert into CT_CSVC values('vc1','PC32',1);
insert into CT_CSVC values('vc2','PC32',6);
insert into CT_CSVC values('vc3','PC32',2);
insert into CT_CSVC values('vc4','PC32',1);
insert into CT_CSVC values('vc5','PC32',1);
insert into CT_CSVC values('vc1','PC33',1);
insert into CT_CSVC values('vc2','PC33',6);
insert into CT_CSVC values('vc3','PC33',2);
insert into CT_CSVC values('vc4','PC33',1);
insert into CT_CSVC values('vc5','PC33',1);
insert into CT_CSVC values('vc1','PC34',1);
insert into CT_CSVC values('vc2','PC34',6);
insert into CT_CSVC values('vc3','PC34',2);
insert into CT_CSVC values('vc4','PC34',1);
insert into CT_CSVC values('vc5','PC34',1);
insert into CT_CSVC values('vc1','PC35',1);
insert into CT_CSVC values('vc2','PC35',6);
insert into CT_CSVC values('vc3','PC35',2);
insert into CT_CSVC values('vc4','PC35',1);
insert into CT_CSVC values('vc5','PC35',1);
insert into CT_CSVC values('vc1','PC36',1);
insert into CT_CSVC values('vc2','PC36',6);
insert into CT_CSVC values('vc3','PC36',2);
insert into CT_CSVC values('vc4','PC36',1);
insert into CT_CSVC values('vc5','PC36',1);
insert into CT_CSVC values('vc1','PC37',1);
insert into CT_CSVC values('vc2','PC37',6);
insert into CT_CSVC values('vc3','PC37',2);
insert into CT_CSVC values('vc4','PC37',1);
insert into CT_CSVC values('vc5','PC37',1);
insert into CT_CSVC values('vc1','PC38',1);
insert into CT_CSVC values('vc2','PC38',6);
insert into CT_CSVC values('vc3','PC38',2);
insert into CT_CSVC values('vc4','PC38',1);
insert into CT_CSVC values('vc5','PC38',1);
insert into CT_CSVC values('vc1','PC39',1);
insert into CT_CSVC values('vc2','PC39',6);
insert into CT_CSVC values('vc3','PC39',2);
insert into CT_CSVC values('vc4','PC39',1);
insert into CT_CSVC values('vc5','PC39',1);
insert into CT_CSVC values('vc1','PC40',1);
insert into CT_CSVC values('vc2','PC40',6);
insert into CT_CSVC values('vc3','PC40',2);
insert into CT_CSVC values('vc4','PC40',1);
insert into CT_CSVC values('vc5','PC40',1);
insert into CT_CSVC values('vc1','PC41',1);
insert into CT_CSVC values('vc2','PC41',6);
insert into CT_CSVC values('vc3','PC41',2);
insert into CT_CSVC values('vc4','PC41',1);
insert into CT_CSVC values('vc5','PC41',1);
insert into CT_CSVC values('vc1','PC42',1);
insert into CT_CSVC values('vc2','PC42',6);
insert into CT_CSVC values('vc3','PC42',2);
insert into CT_CSVC values('vc4','PC42',1);
insert into CT_CSVC values('vc5','PC42',1);
insert into CT_CSVC values('vc1','PC43',1);
insert into CT_CSVC values('vc2','PC43',6);
insert into CT_CSVC values('vc3','PC43',2);
insert into CT_CSVC values('vc4','PC43',1);
insert into CT_CSVC values('vc5','PC43',1);
insert into CT_CSVC values('vc1','PC44',1);
insert into CT_CSVC values('vc2','PC44',6);
insert into CT_CSVC values('vc3','PC44',2);
insert into CT_CSVC values('vc4','PC44',1);
insert into CT_CSVC values('vc5','PC44',1);
insert into CT_CSVC values('vc1','PC45',1);
insert into CT_CSVC values('vc2','PC45',6);
insert into CT_CSVC values('vc3','PC45',2);
insert into CT_CSVC values('vc4','PC45',1);
insert into CT_CSVC values('vc5','PC45',1);
insert into CT_CSVC values('vc1','PC46',1);
insert into CT_CSVC values('vc2','PC46',6);
insert into CT_CSVC values('vc3','PC46',2);
insert into CT_CSVC values('vc4','PC46',1);
insert into CT_CSVC values('vc5','PC46',1);
insert into CT_CSVC values('vc1','PC47',1);
insert into CT_CSVC values('vc2','PC47',6);
insert into CT_CSVC values('vc3','PC47',2);
insert into CT_CSVC values('vc4','PC47',1);
insert into CT_CSVC values('vc5','PC47',1);
insert into CT_CSVC values('vc1','PC48',1);
insert into CT_CSVC values('vc2','PC48',6);
insert into CT_CSVC values('vc3','PC48',2);
insert into CT_CSVC values('vc4','PC48',1);
insert into CT_CSVC values('vc5','PC48',1);
insert into CT_CSVC values('vc1','PC49',1);
insert into CT_CSVC values('vc2','PC49',6);
insert into CT_CSVC values('vc3','PC49',2);
insert into CT_CSVC values('vc4','PC49',1);
insert into CT_CSVC values('vc5','PC49',1);
insert into CT_CSVC values('vc1','PC50',1);
insert into CT_CSVC values('vc2','PC50',6);
insert into CT_CSVC values('vc3','PC50',2);
insert into CT_CSVC values('vc4','PC50',1);
insert into CT_CSVC values('vc5','PC50',1);

insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(55000,1,'PC01','MP01');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,2,'PC02','MP02');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,3,'PC03','MP03');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(70000,4,'PC04','MP04');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,5,'PC05','MP05');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,6,'PC06','MP06');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,7,'PC07','MP07');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,8,'PC08','MP08');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,9,'PC09','MP09');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,10,'PC10','MP10');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(70000,11,'PC11','MP11');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(70000,12,'PC05','MP01');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(70000,13,'PC06','MP02');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(70000,14,'PC07','MP03');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(70000,15,'PC08','MP04');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(70000,16,'PC09','MP05');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(70000,17,'PC10','MP06');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,18,'PC11','MP07');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,19,'PC12','MP08');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,20,'PC13','MP09');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,21,'PC14','MP10');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(65000,22,'PC15','MP11');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,23,'PC01','MP01');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,24,'PC02','MP02');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,25,'PC03','MP03');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,26,'PC04','MP04');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,27,'PC05','MP05');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,28,'PC06','MP06');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,29,'PC07','MP07');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,30,'PC08','MP08');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,31,'PC09','MP09');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,32,'PC10','MP10');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(80000,33,'PC11','MP11');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(55000,34,'PC07','MP01');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(55000,35,'PC08','MP02');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(55000,36,'PC09','MP03');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(55000,37,'PC10','MP04');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(55000,38,'PC11','MP05');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(55000,39,'PC12','MP06');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(55000,40,'PC13','MP07');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(55000,41,'PC14','MP08');
insert into XuatChieu (GiaXuatChieu,Ngay,MaPhong,MaPhim) values(55000,42,'PC15','MP09');

insert into ChiTietGhe values(1,'PC01','g1');
insert into ChiTietGhe values(2,'PC01','g2');
insert into ChiTietGhe values(3,'PC01','g3');
insert into ChiTietGhe values(4,'PC01','g4');
insert into ChiTietGhe values(5,'PC01','g5');
insert into ChiTietGhe values(6,'PC01','g6');
insert into ChiTietGhe values(7,'PC01','g7');
insert into ChiTietGhe values(8,'PC01','g8');
insert into ChiTietGhe values(9,'PC01','g9');
insert into ChiTietGhe values(10,'PC01','g10');
insert into ChiTietGhe values(11,'PC01','g11');
insert into ChiTietGhe values(12,'PC01','g12');
insert into ChiTietGhe values(13,'PC01','g13');
insert into ChiTietGhe values(14,'PC01','g14');
insert into ChiTietGhe values(15,'PC01','g15');
insert into ChiTietGhe values(16,'PC01','g16');
insert into ChiTietGhe values(17,'PC01','g17');
insert into ChiTietGhe values(18,'PC01','g18');
insert into ChiTietGhe values(19,'PC01','g19');
insert into ChiTietGhe values(20,'PC01','g20');
insert into ChiTietGhe values(21,'PC01','g21');
insert into ChiTietGhe values(22,'PC01','g22');
insert into ChiTietGhe values(23,'PC01','g23');
insert into ChiTietGhe values(24,'PC01','g24');
insert into ChiTietGhe values(25,'PC01','g25');
insert into ChiTietGhe values(26,'PC01','g26');
insert into ChiTietGhe values(27,'PC01','g27');
insert into ChiTietGhe values(28,'PC01','g28');
insert into ChiTietGhe values(29,'PC01','g29');
insert into ChiTietGhe values(30,'PC01','g30');
insert into ChiTietGhe values(31,'PC01','g31');
insert into ChiTietGhe values(32,'PC01','g32');
insert into ChiTietGhe values(33,'PC01','g33');
insert into ChiTietGhe values(34,'PC01','g34');
insert into ChiTietGhe values(35,'PC01','g35');
insert into ChiTietGhe values(36,'PC01','g36');
insert into ChiTietGhe values(37,'PC01','g37');
insert into ChiTietGhe values(38,'PC01','g38');
insert into ChiTietGhe values(39,'PC01','g39');
insert into ChiTietGhe values(40,'PC01','g40');
insert into ChiTietGhe values(41,'PC01','g41');
insert into ChiTietGhe values(42,'PC01','g42');
insert into ChiTietGhe values(43,'PC01','g43');
insert into ChiTietGhe values(44,'PC01','g44');
insert into ChiTietGhe values(45,'PC01','g45');
insert into ChiTietGhe values(46,'PC01','g46');
insert into ChiTietGhe values(47,'PC01','g47');
insert into ChiTietGhe values(48,'PC01','g48');
insert into ChiTietGhe values(49,'PC01','g49');
insert into ChiTietGhe values(50,'PC01','g50');
insert into ChiTietGhe values(51,'PC01','g51');
insert into ChiTietGhe values(52,'PC01','g52');
insert into ChiTietGhe values(53,'PC01','g53');
insert into ChiTietGhe values(54,'PC01','g54');
insert into ChiTietGhe values(55,'PC01','g55');
insert into ChiTietGhe values(56,'PC01','g56');
insert into ChiTietGhe values(57,'PC01','g57');
insert into ChiTietGhe values(58,'PC01','g58');
insert into ChiTietGhe values(59,'PC01','g59');
insert into ChiTietGhe values(60,'PC01','g60');
insert into ChiTietGhe values(61,'PC01','g61');
insert into ChiTietGhe values(62,'PC01','g62');
insert into ChiTietGhe values(63,'PC01','g63');
insert into ChiTietGhe values(64,'PC01','g64');
insert into ChiTietGhe values(65,'PC01','g65');
insert into ChiTietGhe values(66,'PC01','g66');
insert into ChiTietGhe values(67,'PC01','g67');
insert into ChiTietGhe values(68,'PC01','g68');
insert into ChiTietGhe values(69,'PC01','g69');
insert into ChiTietGhe values(70,'PC01','g70');
insert into ChiTietGhe values(71,'PC01','g71');
insert into ChiTietGhe values(72,'PC01','g72');
insert into ChiTietGhe values(73,'PC01','g73');
insert into ChiTietGhe values(74,'PC01','g74');
insert into ChiTietGhe values(75,'PC01','g75');
insert into ChiTietGhe values(76,'PC01','g76');
insert into ChiTietGhe values(77,'PC01','g77');
insert into ChiTietGhe values(78,'PC01','g78');
insert into ChiTietGhe values(79,'PC01','g79');
insert into ChiTietGhe values(80,'PC01','g80');
insert into ChiTietGhe values(81,'PC01','g81');
insert into ChiTietGhe values(82,'PC01','g82');
insert into ChiTietGhe values(83,'PC01','g83');
insert into ChiTietGhe values(84,'PC01','g84');
insert into ChiTietGhe values(85,'PC01','g85');
insert into ChiTietGhe values(86,'PC01','g86');
insert into ChiTietGhe values(87,'PC01','g87');
insert into ChiTietGhe values(88,'PC01','g88');
insert into ChiTietGhe values(89,'PC01','g89');
insert into ChiTietGhe values(90,'PC01','g90');
insert into ChiTietGhe values(91,'PC01','g91');
insert into ChiTietGhe values(92,'PC01','g92');
insert into ChiTietGhe values(93,'PC01','g93');
insert into ChiTietGhe values(94,'PC01','g94');
insert into ChiTietGhe values(95,'PC01','g95');
insert into ChiTietGhe values(96,'PC01','g96');
insert into ChiTietGhe values(97,'PC02','g1');
insert into ChiTietGhe values(98,'PC02','g2');
insert into ChiTietGhe values(99,'PC02','g3');
insert into ChiTietGhe values(100,'PC02','g4');
insert into ChiTietGhe values(101,'PC02','g5');
insert into ChiTietGhe values(102,'PC02','g6');
insert into ChiTietGhe values(103,'PC02','g7');
insert into ChiTietGhe values(104,'PC02','g8');
insert into ChiTietGhe values(105,'PC02','g9');
insert into ChiTietGhe values(106,'PC02','g10');
insert into ChiTietGhe values(107,'PC02','g11');
insert into ChiTietGhe values(108,'PC02','g12');
insert into ChiTietGhe values(109,'PC02','g13');
insert into ChiTietGhe values(110,'PC02','g14');
insert into ChiTietGhe values(111,'PC02','g15');
insert into ChiTietGhe values(112,'PC02','g16');
insert into ChiTietGhe values(113,'PC02','g17');
insert into ChiTietGhe values(114,'PC02','g18');
insert into ChiTietGhe values(115,'PC02','g19');
insert into ChiTietGhe values(116,'PC02','g20');
insert into ChiTietGhe values(117,'PC02','g21');
insert into ChiTietGhe values(118,'PC02','g22');
insert into ChiTietGhe values(119,'PC02','g23');
insert into ChiTietGhe values(120,'PC02','g24');
insert into ChiTietGhe values(121,'PC02','g25');
insert into ChiTietGhe values(122,'PC02','g26');
insert into ChiTietGhe values(123,'PC02','g27');
insert into ChiTietGhe values(124,'PC02','g28');
insert into ChiTietGhe values(125,'PC02','g29');
insert into ChiTietGhe values(126,'PC02','g30');
insert into ChiTietGhe values(127,'PC02','g31');
insert into ChiTietGhe values(128,'PC02','g32');
insert into ChiTietGhe values(129,'PC02','g33');
insert into ChiTietGhe values(130,'PC02','g34');
insert into ChiTietGhe values(131,'PC02','g35');
insert into ChiTietGhe values(132,'PC02','g36');
insert into ChiTietGhe values(133,'PC02','g37');
insert into ChiTietGhe values(134,'PC02','g38');
insert into ChiTietGhe values(135,'PC02','g39');
insert into ChiTietGhe values(136,'PC02','g40');
insert into ChiTietGhe values(137,'PC02','g41');
insert into ChiTietGhe values(138,'PC02','g42');
insert into ChiTietGhe values(139,'PC02','g43');
insert into ChiTietGhe values(140,'PC02','g44');
insert into ChiTietGhe values(141,'PC02','g45');
insert into ChiTietGhe values(142,'PC02','g46');
insert into ChiTietGhe values(143,'PC02','g47');
insert into ChiTietGhe values(144,'PC02','g48');
insert into ChiTietGhe values(145,'PC02','g49');
insert into ChiTietGhe values(146,'PC02','g50');
insert into ChiTietGhe values(147,'PC02','g51');
insert into ChiTietGhe values(148,'PC02','g52');
insert into ChiTietGhe values(149,'PC02','g53');
insert into ChiTietGhe values(150,'PC02','g54');
insert into ChiTietGhe values(151,'PC02','g55');
insert into ChiTietGhe values(152,'PC02','g56');
insert into ChiTietGhe values(153,'PC02','g57');
insert into ChiTietGhe values(154,'PC02','g58');
insert into ChiTietGhe values(155,'PC02','g59');
insert into ChiTietGhe values(156,'PC02','g60');
insert into ChiTietGhe values(157,'PC02','g61');
insert into ChiTietGhe values(158,'PC02','g62');
insert into ChiTietGhe values(159,'PC02','g63');
insert into ChiTietGhe values(160,'PC02','g64');
insert into ChiTietGhe values(161,'PC02','g65');
insert into ChiTietGhe values(162,'PC02','g66');
insert into ChiTietGhe values(163,'PC02','g67');
insert into ChiTietGhe values(164,'PC02','g68');
insert into ChiTietGhe values(165,'PC02','g69');
insert into ChiTietGhe values(166,'PC02','g70');
insert into ChiTietGhe values(167,'PC02','g71');
insert into ChiTietGhe values(168,'PC02','g72');
insert into ChiTietGhe values(169,'PC02','g73');
insert into ChiTietGhe values(170,'PC02','g74');
insert into ChiTietGhe values(171,'PC02','g75');
insert into ChiTietGhe values(172,'PC02','g76');
insert into ChiTietGhe values(173,'PC02','g77');
insert into ChiTietGhe values(174,'PC02','g78');
insert into ChiTietGhe values(175,'PC02','g79');
insert into ChiTietGhe values(176,'PC02','g80');
insert into ChiTietGhe values(177,'PC02','g81');
insert into ChiTietGhe values(178,'PC02','g82');
insert into ChiTietGhe values(179,'PC02','g83');
insert into ChiTietGhe values(180,'PC02','g84');
insert into ChiTietGhe values(181,'PC02','g85');
insert into ChiTietGhe values(182,'PC02','g86');
insert into ChiTietGhe values(183,'PC02','g87');
insert into ChiTietGhe values(184,'PC02','g88');
insert into ChiTietGhe values(185,'PC02','g89');
insert into ChiTietGhe values(186,'PC02','g90');
insert into ChiTietGhe values(187,'PC02','g91');
insert into ChiTietGhe values(188,'PC02','g92');
insert into ChiTietGhe values(189,'PC02','g93');
insert into ChiTietGhe values(190,'PC02','g94');
insert into ChiTietGhe values(191,'PC02','g95');
insert into ChiTietGhe values(192,'PC02','g96');
insert into ChiTietGhe values(193,'PC03','g1');
insert into ChiTietGhe values(194,'PC03','g2');
insert into ChiTietGhe values(195,'PC03','g3');
insert into ChiTietGhe values(196,'PC03','g4');
insert into ChiTietGhe values(197,'PC03','g5');
insert into ChiTietGhe values(198,'PC03','g6');
insert into ChiTietGhe values(199,'PC03','g7');
insert into ChiTietGhe values(200,'PC03','g8');
insert into ChiTietGhe values(201,'PC03','g9');
insert into ChiTietGhe values(202,'PC03','g10');
insert into ChiTietGhe values(203,'PC03','g11');
insert into ChiTietGhe values(204,'PC03','g12');
insert into ChiTietGhe values(205,'PC03','g13');
insert into ChiTietGhe values(206,'PC03','g14');
insert into ChiTietGhe values(207,'PC03','g15');
insert into ChiTietGhe values(208,'PC03','g16');
insert into ChiTietGhe values(209,'PC03','g17');
insert into ChiTietGhe values(210,'PC03','g18');
insert into ChiTietGhe values(211,'PC03','g19');
insert into ChiTietGhe values(212,'PC03','g20');
insert into ChiTietGhe values(213,'PC03','g21');
insert into ChiTietGhe values(214,'PC03','g22');
insert into ChiTietGhe values(215,'PC03','g23');
insert into ChiTietGhe values(216,'PC03','g24');
insert into ChiTietGhe values(217,'PC03','g25');
insert into ChiTietGhe values(218,'PC03','g26');
insert into ChiTietGhe values(219,'PC03','g27');
insert into ChiTietGhe values(220,'PC03','g28');
insert into ChiTietGhe values(221,'PC03','g29');
insert into ChiTietGhe values(222,'PC03','g30');
insert into ChiTietGhe values(223,'PC03','g31');
insert into ChiTietGhe values(224,'PC03','g32');
insert into ChiTietGhe values(225,'PC03','g33');
insert into ChiTietGhe values(226,'PC03','g34');
insert into ChiTietGhe values(227,'PC03','g35');
insert into ChiTietGhe values(228,'PC03','g36');
insert into ChiTietGhe values(229,'PC03','g37');
insert into ChiTietGhe values(230,'PC03','g38');
insert into ChiTietGhe values(231,'PC03','g39');
insert into ChiTietGhe values(232,'PC03','g40');
insert into ChiTietGhe values(233,'PC03','g41');
insert into ChiTietGhe values(234,'PC03','g42');
insert into ChiTietGhe values(235,'PC03','g43');
insert into ChiTietGhe values(236,'PC03','g44');
insert into ChiTietGhe values(237,'PC03','g45');
insert into ChiTietGhe values(238,'PC03','g46');
insert into ChiTietGhe values(239,'PC03','g47');
insert into ChiTietGhe values(240,'PC03','g48');
insert into ChiTietGhe values(241,'PC03','g49');
insert into ChiTietGhe values(242,'PC03','g50');
insert into ChiTietGhe values(243,'PC03','g51');
insert into ChiTietGhe values(244,'PC03','g52');
insert into ChiTietGhe values(245,'PC03','g53');
insert into ChiTietGhe values(246,'PC03','g54');
insert into ChiTietGhe values(247,'PC03','g55');
insert into ChiTietGhe values(248,'PC03','g56');
insert into ChiTietGhe values(249,'PC03','g57');
insert into ChiTietGhe values(250,'PC03','g58');
insert into ChiTietGhe values(251,'PC03','g59');
insert into ChiTietGhe values(252,'PC03','g60');
insert into ChiTietGhe values(253,'PC03','g61');
insert into ChiTietGhe values(254,'PC03','g62');
insert into ChiTietGhe values(255,'PC03','g63');
insert into ChiTietGhe values(256,'PC03','g64');
insert into ChiTietGhe values(257,'PC03','g65');
insert into ChiTietGhe values(258,'PC03','g66');
insert into ChiTietGhe values(259,'PC03','g67');
insert into ChiTietGhe values(260,'PC03','g68');
insert into ChiTietGhe values(261,'PC03','g69');
insert into ChiTietGhe values(262,'PC03','g70');
insert into ChiTietGhe values(263,'PC03','g71');
insert into ChiTietGhe values(264,'PC03','g72');
insert into ChiTietGhe values(265,'PC03','g73');
insert into ChiTietGhe values(266,'PC03','g74');
insert into ChiTietGhe values(267,'PC03','g75');
insert into ChiTietGhe values(268,'PC03','g76');
insert into ChiTietGhe values(269,'PC03','g77');
insert into ChiTietGhe values(270,'PC03','g78');
insert into ChiTietGhe values(271,'PC03','g79');
insert into ChiTietGhe values(272,'PC03','g80');
insert into ChiTietGhe values(273,'PC03','g81');
insert into ChiTietGhe values(274,'PC03','g82');
insert into ChiTietGhe values(275,'PC03','g83');
insert into ChiTietGhe values(276,'PC03','g84');
insert into ChiTietGhe values(277,'PC03','g85');
insert into ChiTietGhe values(278,'PC03','g86');
insert into ChiTietGhe values(279,'PC03','g87');
insert into ChiTietGhe values(280,'PC03','g88');
insert into ChiTietGhe values(281,'PC03','g89');
insert into ChiTietGhe values(282,'PC03','g90');
insert into ChiTietGhe values(283,'PC03','g91');
insert into ChiTietGhe values(284,'PC03','g92');
insert into ChiTietGhe values(285,'PC03','g93');
insert into ChiTietGhe values(286,'PC03','g94');
insert into ChiTietGhe values(287,'PC03','g95');
insert into ChiTietGhe values(288,'PC03','g96');
insert into ChiTietGhe values(289,'PC04','g1');
insert into ChiTietGhe values(290,'PC04','g2');
insert into ChiTietGhe values(291,'PC04','g3');
insert into ChiTietGhe values(292,'PC04','g4');
insert into ChiTietGhe values(293,'PC04','g5');
insert into ChiTietGhe values(294,'PC04','g6');
insert into ChiTietGhe values(295,'PC04','g7');
insert into ChiTietGhe values(296,'PC04','g8');
insert into ChiTietGhe values(297,'PC04','g9');
insert into ChiTietGhe values(298,'PC04','g10');
insert into ChiTietGhe values(299,'PC04','g11');
insert into ChiTietGhe values(300,'PC04','g12');
insert into ChiTietGhe values(301,'PC04','g13');
insert into ChiTietGhe values(302,'PC04','g14');
insert into ChiTietGhe values(303,'PC04','g15');
insert into ChiTietGhe values(304,'PC04','g16');
insert into ChiTietGhe values(305,'PC04','g17');
insert into ChiTietGhe values(306,'PC04','g18');
insert into ChiTietGhe values(307,'PC04','g19');
insert into ChiTietGhe values(308,'PC04','g20');
insert into ChiTietGhe values(309,'PC04','g21');
insert into ChiTietGhe values(310,'PC04','g22');
insert into ChiTietGhe values(311,'PC04','g23');
insert into ChiTietGhe values(312,'PC04','g24');
insert into ChiTietGhe values(313,'PC04','g25');
insert into ChiTietGhe values(314,'PC04','g26');
insert into ChiTietGhe values(315,'PC04','g27');
insert into ChiTietGhe values(316,'PC04','g28');
insert into ChiTietGhe values(317,'PC04','g29');
insert into ChiTietGhe values(318,'PC04','g30');
insert into ChiTietGhe values(319,'PC04','g31');
insert into ChiTietGhe values(320,'PC04','g32');
insert into ChiTietGhe values(321,'PC04','g33');
insert into ChiTietGhe values(322,'PC04','g34');
insert into ChiTietGhe values(323,'PC04','g35');
insert into ChiTietGhe values(324,'PC04','g36');
insert into ChiTietGhe values(325,'PC04','g37');
insert into ChiTietGhe values(326,'PC04','g38');
insert into ChiTietGhe values(327,'PC04','g39');
insert into ChiTietGhe values(328,'PC04','g40');
insert into ChiTietGhe values(329,'PC04','g41');
insert into ChiTietGhe values(330,'PC04','g42');
insert into ChiTietGhe values(331,'PC04','g43');
insert into ChiTietGhe values(332,'PC04','g44');
insert into ChiTietGhe values(333,'PC04','g45');
insert into ChiTietGhe values(334,'PC04','g46');
insert into ChiTietGhe values(335,'PC04','g47');
insert into ChiTietGhe values(336,'PC04','g48');
insert into ChiTietGhe values(337,'PC04','g49');
insert into ChiTietGhe values(338,'PC04','g50');
insert into ChiTietGhe values(339,'PC04','g51');
insert into ChiTietGhe values(340,'PC04','g52');
insert into ChiTietGhe values(341,'PC04','g53');
insert into ChiTietGhe values(342,'PC04','g54');
insert into ChiTietGhe values(343,'PC04','g55');
insert into ChiTietGhe values(344,'PC04','g56');
insert into ChiTietGhe values(345,'PC04','g57');
insert into ChiTietGhe values(346,'PC04','g58');
insert into ChiTietGhe values(347,'PC04','g59');
insert into ChiTietGhe values(348,'PC04','g60');
insert into ChiTietGhe values(349,'PC04','g61');
insert into ChiTietGhe values(350,'PC04','g62');
insert into ChiTietGhe values(351,'PC04','g63');
insert into ChiTietGhe values(352,'PC04','g64');
insert into ChiTietGhe values(353,'PC04','g65');
insert into ChiTietGhe values(354,'PC04','g66');
insert into ChiTietGhe values(355,'PC04','g67');
insert into ChiTietGhe values(356,'PC04','g68');
insert into ChiTietGhe values(357,'PC04','g69');
insert into ChiTietGhe values(358,'PC04','g70');
insert into ChiTietGhe values(359,'PC04','g71');
insert into ChiTietGhe values(360,'PC04','g72');
insert into ChiTietGhe values(361,'PC04','g73');
insert into ChiTietGhe values(362,'PC04','g74');
insert into ChiTietGhe values(363,'PC04','g75');
insert into ChiTietGhe values(364,'PC04','g76');
insert into ChiTietGhe values(365,'PC04','g77');
insert into ChiTietGhe values(366,'PC04','g78');
insert into ChiTietGhe values(367,'PC04','g79');
insert into ChiTietGhe values(368,'PC04','g80');
insert into ChiTietGhe values(369,'PC04','g81');
insert into ChiTietGhe values(370,'PC04','g82');
insert into ChiTietGhe values(371,'PC04','g83');
insert into ChiTietGhe values(372,'PC04','g84');
insert into ChiTietGhe values(373,'PC04','g85');
insert into ChiTietGhe values(374,'PC04','g86');
insert into ChiTietGhe values(375,'PC04','g87');
insert into ChiTietGhe values(376,'PC04','g88');
insert into ChiTietGhe values(377,'PC04','g89');
insert into ChiTietGhe values(378,'PC04','g90');
insert into ChiTietGhe values(379,'PC04','g91');
insert into ChiTietGhe values(380,'PC04','g92');
insert into ChiTietGhe values(381,'PC04','g93');
insert into ChiTietGhe values(382,'PC04','g94');
insert into ChiTietGhe values(383,'PC04','g95');
insert into ChiTietGhe values(384,'PC04','g96');
insert into ChiTietGhe values(385,'PC05','g1');
insert into ChiTietGhe values(386,'PC05','g2');
insert into ChiTietGhe values(387,'PC05','g3');
insert into ChiTietGhe values(388,'PC05','g4');
insert into ChiTietGhe values(389,'PC05','g5');
insert into ChiTietGhe values(390,'PC05','g6');
insert into ChiTietGhe values(391,'PC05','g7');
insert into ChiTietGhe values(392,'PC05','g8');
insert into ChiTietGhe values(393,'PC05','g9');
insert into ChiTietGhe values(394,'PC05','g10');
insert into ChiTietGhe values(395,'PC05','g11');
insert into ChiTietGhe values(396,'PC05','g12');
insert into ChiTietGhe values(397,'PC05','g13');
insert into ChiTietGhe values(398,'PC05','g14');
insert into ChiTietGhe values(399,'PC05','g15');
insert into ChiTietGhe values(400,'PC05','g16');
insert into ChiTietGhe values(401,'PC05','g17');
insert into ChiTietGhe values(402,'PC05','g18');
insert into ChiTietGhe values(403,'PC05','g19');
insert into ChiTietGhe values(404,'PC05','g20');
insert into ChiTietGhe values(405,'PC05','g21');
insert into ChiTietGhe values(406,'PC05','g22');
insert into ChiTietGhe values(407,'PC05','g23');
insert into ChiTietGhe values(408,'PC05','g24');
insert into ChiTietGhe values(409,'PC05','g25');
insert into ChiTietGhe values(410,'PC05','g26');
insert into ChiTietGhe values(411,'PC05','g27');
insert into ChiTietGhe values(412,'PC05','g28');
insert into ChiTietGhe values(413,'PC05','g29');
insert into ChiTietGhe values(414,'PC05','g30');
insert into ChiTietGhe values(415,'PC05','g31');
insert into ChiTietGhe values(416,'PC05','g32');
insert into ChiTietGhe values(417,'PC05','g33');
insert into ChiTietGhe values(418,'PC05','g34');
insert into ChiTietGhe values(419,'PC05','g35');
insert into ChiTietGhe values(420,'PC05','g36');
insert into ChiTietGhe values(421,'PC05','g37');
insert into ChiTietGhe values(422,'PC05','g38');
insert into ChiTietGhe values(423,'PC05','g39');
insert into ChiTietGhe values(424,'PC05','g40');
insert into ChiTietGhe values(425,'PC05','g41');
insert into ChiTietGhe values(426,'PC05','g42');
insert into ChiTietGhe values(427,'PC05','g43');
insert into ChiTietGhe values(428,'PC05','g44');
insert into ChiTietGhe values(429,'PC05','g45');
insert into ChiTietGhe values(430,'PC05','g46');
insert into ChiTietGhe values(431,'PC05','g47');
insert into ChiTietGhe values(432,'PC05','g48');
insert into ChiTietGhe values(433,'PC05','g49');
insert into ChiTietGhe values(434,'PC05','g50');
insert into ChiTietGhe values(435,'PC05','g51');
insert into ChiTietGhe values(436,'PC05','g52');
insert into ChiTietGhe values(437,'PC05','g53');
insert into ChiTietGhe values(438,'PC05','g54');
insert into ChiTietGhe values(439,'PC05','g55');
insert into ChiTietGhe values(440,'PC05','g56');
insert into ChiTietGhe values(441,'PC05','g57');
insert into ChiTietGhe values(442,'PC05','g58');
insert into ChiTietGhe values(443,'PC05','g59');
insert into ChiTietGhe values(444,'PC05','g60');
insert into ChiTietGhe values(445,'PC05','g61');
insert into ChiTietGhe values(446,'PC05','g62');
insert into ChiTietGhe values(447,'PC05','g63');
insert into ChiTietGhe values(448,'PC05','g64');
insert into ChiTietGhe values(449,'PC05','g65');
insert into ChiTietGhe values(450,'PC05','g66');
insert into ChiTietGhe values(451,'PC05','g67');
insert into ChiTietGhe values(452,'PC05','g68');
insert into ChiTietGhe values(453,'PC05','g69');
insert into ChiTietGhe values(454,'PC05','g70');
insert into ChiTietGhe values(455,'PC05','g71');
insert into ChiTietGhe values(456,'PC05','g72');
insert into ChiTietGhe values(457,'PC05','g73');
insert into ChiTietGhe values(458,'PC05','g74');
insert into ChiTietGhe values(459,'PC05','g75');
insert into ChiTietGhe values(460,'PC05','g76');
insert into ChiTietGhe values(461,'PC05','g77');
insert into ChiTietGhe values(462,'PC05','g78');
insert into ChiTietGhe values(463,'PC05','g79');
insert into ChiTietGhe values(464,'PC05','g80');
insert into ChiTietGhe values(465,'PC05','g81');
insert into ChiTietGhe values(466,'PC05','g82');
insert into ChiTietGhe values(467,'PC05','g83');
insert into ChiTietGhe values(468,'PC05','g84');
insert into ChiTietGhe values(469,'PC05','g85');
insert into ChiTietGhe values(470,'PC05','g86');
insert into ChiTietGhe values(471,'PC05','g87');
insert into ChiTietGhe values(472,'PC05','g88');
insert into ChiTietGhe values(473,'PC05','g89');
insert into ChiTietGhe values(474,'PC05','g90');
insert into ChiTietGhe values(475,'PC05','g91');
insert into ChiTietGhe values(476,'PC05','g92');
insert into ChiTietGhe values(477,'PC05','g93');
insert into ChiTietGhe values(478,'PC05','g94');
insert into ChiTietGhe values(479,'PC05','g95');
insert into ChiTietGhe values(480,'PC05','g96');
insert into ChiTietGhe values(481,'PC06','g1');
insert into ChiTietGhe values(482,'PC06','g2');
insert into ChiTietGhe values(483,'PC06','g3');
insert into ChiTietGhe values(484,'PC06','g4');
insert into ChiTietGhe values(485,'PC06','g5');
insert into ChiTietGhe values(486,'PC06','g6');
insert into ChiTietGhe values(487,'PC06','g7');
insert into ChiTietGhe values(488,'PC06','g8');
insert into ChiTietGhe values(489,'PC06','g9');
insert into ChiTietGhe values(490,'PC06','g10');
insert into ChiTietGhe values(491,'PC06','g11');
insert into ChiTietGhe values(492,'PC06','g12');
insert into ChiTietGhe values(493,'PC06','g13');
insert into ChiTietGhe values(494,'PC06','g14');
insert into ChiTietGhe values(495,'PC06','g15');
insert into ChiTietGhe values(496,'PC06','g16');
insert into ChiTietGhe values(497,'PC06','g17');
insert into ChiTietGhe values(498,'PC06','g18');
insert into ChiTietGhe values(499,'PC06','g19');
insert into ChiTietGhe values(500,'PC06','g20');
insert into ChiTietGhe values(501,'PC06','g21');
insert into ChiTietGhe values(502,'PC06','g22');
insert into ChiTietGhe values(503,'PC06','g23');
insert into ChiTietGhe values(504,'PC06','g24');
insert into ChiTietGhe values(505,'PC06','g25');
insert into ChiTietGhe values(506,'PC06','g26');
insert into ChiTietGhe values(507,'PC06','g27');
insert into ChiTietGhe values(508,'PC06','g28');
insert into ChiTietGhe values(509,'PC06','g29');
insert into ChiTietGhe values(510,'PC06','g30');
insert into ChiTietGhe values(511,'PC06','g31');
insert into ChiTietGhe values(512,'PC06','g32');
insert into ChiTietGhe values(513,'PC06','g33');
insert into ChiTietGhe values(514,'PC06','g34');
insert into ChiTietGhe values(515,'PC06','g35');
insert into ChiTietGhe values(516,'PC06','g36');
insert into ChiTietGhe values(517,'PC06','g37');
insert into ChiTietGhe values(518,'PC06','g38');
insert into ChiTietGhe values(519,'PC06','g39');
insert into ChiTietGhe values(520,'PC06','g40');
insert into ChiTietGhe values(521,'PC06','g41');
insert into ChiTietGhe values(522,'PC06','g42');
insert into ChiTietGhe values(523,'PC06','g43');
insert into ChiTietGhe values(524,'PC06','g44');
insert into ChiTietGhe values(525,'PC06','g45');
insert into ChiTietGhe values(526,'PC06','g46');
insert into ChiTietGhe values(527,'PC06','g47');
insert into ChiTietGhe values(528,'PC06','g48');
insert into ChiTietGhe values(529,'PC06','g49');
insert into ChiTietGhe values(530,'PC06','g50');
insert into ChiTietGhe values(531,'PC06','g51');
insert into ChiTietGhe values(532,'PC06','g52');
insert into ChiTietGhe values(533,'PC06','g53');
insert into ChiTietGhe values(534,'PC06','g54');
insert into ChiTietGhe values(535,'PC06','g55');
insert into ChiTietGhe values(536,'PC06','g56');
insert into ChiTietGhe values(537,'PC06','g57');
insert into ChiTietGhe values(538,'PC06','g58');
insert into ChiTietGhe values(539,'PC06','g59');
insert into ChiTietGhe values(540,'PC06','g60');
insert into ChiTietGhe values(541,'PC06','g61');
insert into ChiTietGhe values(542,'PC06','g62');
insert into ChiTietGhe values(543,'PC06','g63');
insert into ChiTietGhe values(544,'PC06','g64');
insert into ChiTietGhe values(545,'PC06','g65');
insert into ChiTietGhe values(546,'PC06','g66');
insert into ChiTietGhe values(547,'PC06','g67');
insert into ChiTietGhe values(548,'PC06','g68');
insert into ChiTietGhe values(549,'PC06','g69');
insert into ChiTietGhe values(550,'PC06','g70');
insert into ChiTietGhe values(551,'PC06','g71');
insert into ChiTietGhe values(552,'PC06','g72');
insert into ChiTietGhe values(553,'PC06','g73');
insert into ChiTietGhe values(554,'PC06','g74');
insert into ChiTietGhe values(555,'PC06','g75');
insert into ChiTietGhe values(556,'PC06','g76');
insert into ChiTietGhe values(557,'PC06','g77');
insert into ChiTietGhe values(558,'PC06','g78');
insert into ChiTietGhe values(559,'PC06','g79');
insert into ChiTietGhe values(560,'PC06','g80');
insert into ChiTietGhe values(561,'PC06','g81');
insert into ChiTietGhe values(562,'PC06','g82');
insert into ChiTietGhe values(563,'PC06','g83');
insert into ChiTietGhe values(564,'PC06','g84');
insert into ChiTietGhe values(565,'PC06','g85');
insert into ChiTietGhe values(566,'PC06','g86');
insert into ChiTietGhe values(567,'PC06','g87');
insert into ChiTietGhe values(568,'PC06','g88');
insert into ChiTietGhe values(569,'PC06','g89');
insert into ChiTietGhe values(570,'PC06','g90');
insert into ChiTietGhe values(571,'PC06','g91');
insert into ChiTietGhe values(572,'PC06','g92');
insert into ChiTietGhe values(573,'PC06','g93');
insert into ChiTietGhe values(574,'PC06','g94');
insert into ChiTietGhe values(575,'PC06','g95');
insert into ChiTietGhe values(576,'PC06','g96');
insert into ChiTietGhe values(577,'PC06','g97');
insert into ChiTietGhe values(578,'PC06','g98');
insert into ChiTietGhe values(579,'PC06','g99');
insert into ChiTietGhe values(580,'PC06','g100');
insert into ChiTietGhe values(581,'PC06','g101');
insert into ChiTietGhe values(582,'PC06','g102');
insert into ChiTietGhe values(583,'PC06','g103');
insert into ChiTietGhe values(584,'PC06','g104');
insert into ChiTietGhe values(585,'PC06','g105');
insert into ChiTietGhe values(586,'PC06','g106');
insert into ChiTietGhe values(587,'PC06','g107');
insert into ChiTietGhe values(588,'PC06','g108');
insert into ChiTietGhe values(589,'PC06','g109');
insert into ChiTietGhe values(590,'PC06','g110');
insert into ChiTietGhe values(591,'PC07','g1');
insert into ChiTietGhe values(592,'PC07','g2');
insert into ChiTietGhe values(593,'PC07','g3');
insert into ChiTietGhe values(594,'PC07','g4');
insert into ChiTietGhe values(595,'PC07','g5');
insert into ChiTietGhe values(596,'PC07','g6');
insert into ChiTietGhe values(597,'PC07','g7');
insert into ChiTietGhe values(598,'PC07','g8');
insert into ChiTietGhe values(599,'PC07','g9');
insert into ChiTietGhe values(600,'PC07','g10');
insert into ChiTietGhe values(601,'PC07','g11');
insert into ChiTietGhe values(602,'PC07','g12');
insert into ChiTietGhe values(603,'PC07','g13');
insert into ChiTietGhe values(604,'PC07','g14');
insert into ChiTietGhe values(605,'PC07','g15');
insert into ChiTietGhe values(606,'PC07','g16');
insert into ChiTietGhe values(607,'PC07','g17');
insert into ChiTietGhe values(608,'PC07','g18');
insert into ChiTietGhe values(609,'PC07','g19');
insert into ChiTietGhe values(610,'PC07','g20');
insert into ChiTietGhe values(611,'PC07','g21');
insert into ChiTietGhe values(612,'PC07','g22');
insert into ChiTietGhe values(613,'PC07','g23');
insert into ChiTietGhe values(614,'PC07','g24');
insert into ChiTietGhe values(615,'PC07','g25');
insert into ChiTietGhe values(616,'PC07','g26');
insert into ChiTietGhe values(617,'PC07','g27');
insert into ChiTietGhe values(618,'PC07','g28');
insert into ChiTietGhe values(619,'PC07','g29');
insert into ChiTietGhe values(620,'PC07','g30');
insert into ChiTietGhe values(621,'PC07','g31');
insert into ChiTietGhe values(622,'PC07','g32');
insert into ChiTietGhe values(623,'PC07','g33');
insert into ChiTietGhe values(624,'PC07','g34');
insert into ChiTietGhe values(625,'PC07','g35');
insert into ChiTietGhe values(626,'PC07','g36');
insert into ChiTietGhe values(627,'PC07','g37');
insert into ChiTietGhe values(628,'PC07','g38');
insert into ChiTietGhe values(629,'PC07','g39');
insert into ChiTietGhe values(630,'PC07','g40');
insert into ChiTietGhe values(631,'PC07','g41');
insert into ChiTietGhe values(632,'PC07','g42');
insert into ChiTietGhe values(633,'PC07','g43');
insert into ChiTietGhe values(634,'PC07','g44');
insert into ChiTietGhe values(635,'PC07','g45');
insert into ChiTietGhe values(636,'PC07','g46');
insert into ChiTietGhe values(637,'PC07','g47');
insert into ChiTietGhe values(638,'PC07','g48');
insert into ChiTietGhe values(639,'PC07','g49');
insert into ChiTietGhe values(640,'PC07','g50');
insert into ChiTietGhe values(641,'PC07','g51');
insert into ChiTietGhe values(642,'PC07','g52');
insert into ChiTietGhe values(643,'PC07','g53');
insert into ChiTietGhe values(644,'PC07','g54');
insert into ChiTietGhe values(645,'PC07','g55');
insert into ChiTietGhe values(646,'PC07','g56');
insert into ChiTietGhe values(647,'PC07','g57');
insert into ChiTietGhe values(648,'PC07','g58');
insert into ChiTietGhe values(649,'PC07','g59');
insert into ChiTietGhe values(650,'PC07','g60');
insert into ChiTietGhe values(651,'PC07','g61');
insert into ChiTietGhe values(652,'PC07','g62');
insert into ChiTietGhe values(653,'PC07','g63');
insert into ChiTietGhe values(654,'PC07','g64');
insert into ChiTietGhe values(655,'PC07','g65');
insert into ChiTietGhe values(656,'PC07','g66');
insert into ChiTietGhe values(657,'PC07','g67');
insert into ChiTietGhe values(658,'PC07','g68');
insert into ChiTietGhe values(659,'PC07','g69');
insert into ChiTietGhe values(660,'PC07','g70');
insert into ChiTietGhe values(661,'PC07','g71');
insert into ChiTietGhe values(662,'PC07','g72');
insert into ChiTietGhe values(663,'PC07','g73');
insert into ChiTietGhe values(664,'PC07','g74');
insert into ChiTietGhe values(665,'PC07','g75');
insert into ChiTietGhe values(666,'PC07','g76');
insert into ChiTietGhe values(667,'PC07','g77');
insert into ChiTietGhe values(668,'PC07','g78');
insert into ChiTietGhe values(669,'PC07','g79');
insert into ChiTietGhe values(670,'PC07','g80');
insert into ChiTietGhe values(671,'PC07','g81');
insert into ChiTietGhe values(672,'PC07','g82');
insert into ChiTietGhe values(673,'PC07','g83');
insert into ChiTietGhe values(674,'PC07','g84');
insert into ChiTietGhe values(675,'PC07','g85');
insert into ChiTietGhe values(676,'PC07','g86');
insert into ChiTietGhe values(677,'PC07','g87');
insert into ChiTietGhe values(678,'PC07','g88');
insert into ChiTietGhe values(679,'PC07','g89');
insert into ChiTietGhe values(680,'PC07','g90');
insert into ChiTietGhe values(681,'PC07','g91');
insert into ChiTietGhe values(682,'PC07','g92');
insert into ChiTietGhe values(683,'PC07','g93');
insert into ChiTietGhe values(684,'PC07','g94');
insert into ChiTietGhe values(685,'PC07','g95');
insert into ChiTietGhe values(686,'PC07','g96');
insert into ChiTietGhe values(687,'PC07','g97');
insert into ChiTietGhe values(688,'PC07','g98');
insert into ChiTietGhe values(689,'PC07','g99');
insert into ChiTietGhe values(690,'PC07','g100');
insert into ChiTietGhe values(691,'PC07','g101');
insert into ChiTietGhe values(692,'PC07','g102');
insert into ChiTietGhe values(693,'PC07','g103');
insert into ChiTietGhe values(694,'PC07','g104');
insert into ChiTietGhe values(695,'PC07','g105');
insert into ChiTietGhe values(696,'PC07','g106');
insert into ChiTietGhe values(697,'PC07','g107');
insert into ChiTietGhe values(698,'PC07','g108');
insert into ChiTietGhe values(699,'PC07','g109');
insert into ChiTietGhe values(700,'PC07','g110');
insert into ChiTietGhe values(701,'PC08','g1');
insert into ChiTietGhe values(702,'PC08','g2');
insert into ChiTietGhe values(703,'PC08','g3');
insert into ChiTietGhe values(704,'PC08','g4');
insert into ChiTietGhe values(705,'PC08','g5');
insert into ChiTietGhe values(706,'PC08','g6');
insert into ChiTietGhe values(707,'PC08','g7');
insert into ChiTietGhe values(708,'PC08','g8');
insert into ChiTietGhe values(709,'PC08','g9');
insert into ChiTietGhe values(710,'PC08','g10');
insert into ChiTietGhe values(711,'PC08','g11');
insert into ChiTietGhe values(712,'PC08','g12');
insert into ChiTietGhe values(713,'PC08','g13');
insert into ChiTietGhe values(714,'PC08','g14');
insert into ChiTietGhe values(715,'PC08','g15');
insert into ChiTietGhe values(716,'PC08','g16');
insert into ChiTietGhe values(717,'PC08','g17');
insert into ChiTietGhe values(718,'PC08','g18');
insert into ChiTietGhe values(719,'PC08','g19');
insert into ChiTietGhe values(720,'PC08','g20');
insert into ChiTietGhe values(721,'PC08','g21');
insert into ChiTietGhe values(722,'PC08','g22');
insert into ChiTietGhe values(723,'PC08','g23');
insert into ChiTietGhe values(724,'PC08','g24');
insert into ChiTietGhe values(725,'PC08','g25');
insert into ChiTietGhe values(726,'PC08','g26');
insert into ChiTietGhe values(727,'PC08','g27');
insert into ChiTietGhe values(728,'PC08','g28');
insert into ChiTietGhe values(729,'PC08','g29');
insert into ChiTietGhe values(730,'PC08','g30');
insert into ChiTietGhe values(731,'PC08','g31');
insert into ChiTietGhe values(732,'PC08','g32');
insert into ChiTietGhe values(733,'PC08','g33');
insert into ChiTietGhe values(734,'PC08','g34');
insert into ChiTietGhe values(735,'PC08','g35');
insert into ChiTietGhe values(736,'PC08','g36');
insert into ChiTietGhe values(737,'PC08','g37');
insert into ChiTietGhe values(738,'PC08','g38');
insert into ChiTietGhe values(739,'PC08','g39');
insert into ChiTietGhe values(740,'PC08','g40');
insert into ChiTietGhe values(741,'PC08','g41');
insert into ChiTietGhe values(742,'PC08','g42');
insert into ChiTietGhe values(743,'PC08','g43');
insert into ChiTietGhe values(744,'PC08','g44');
insert into ChiTietGhe values(745,'PC08','g45');
insert into ChiTietGhe values(746,'PC08','g46');
insert into ChiTietGhe values(747,'PC08','g47');
insert into ChiTietGhe values(748,'PC08','g48');
insert into ChiTietGhe values(749,'PC08','g49');
insert into ChiTietGhe values(750,'PC08','g50');
insert into ChiTietGhe values(751,'PC08','g51');
insert into ChiTietGhe values(752,'PC08','g52');
insert into ChiTietGhe values(753,'PC08','g53');
insert into ChiTietGhe values(754,'PC08','g54');
insert into ChiTietGhe values(755,'PC08','g55');
insert into ChiTietGhe values(756,'PC08','g56');
insert into ChiTietGhe values(757,'PC08','g57');
insert into ChiTietGhe values(758,'PC08','g58');
insert into ChiTietGhe values(759,'PC08','g59');
insert into ChiTietGhe values(760,'PC08','g60');
insert into ChiTietGhe values(761,'PC08','g61');
insert into ChiTietGhe values(762,'PC08','g62');
insert into ChiTietGhe values(763,'PC08','g63');
insert into ChiTietGhe values(764,'PC08','g64');
insert into ChiTietGhe values(765,'PC08','g65');
insert into ChiTietGhe values(766,'PC08','g66');
insert into ChiTietGhe values(767,'PC08','g67');
insert into ChiTietGhe values(768,'PC08','g68');
insert into ChiTietGhe values(769,'PC08','g69');
insert into ChiTietGhe values(770,'PC08','g70');
insert into ChiTietGhe values(771,'PC08','g71');
insert into ChiTietGhe values(772,'PC08','g72');
insert into ChiTietGhe values(773,'PC08','g73');
insert into ChiTietGhe values(774,'PC08','g74');
insert into ChiTietGhe values(775,'PC08','g75');
insert into ChiTietGhe values(776,'PC08','g76');
insert into ChiTietGhe values(777,'PC08','g77');
insert into ChiTietGhe values(778,'PC08','g78');
insert into ChiTietGhe values(779,'PC08','g79');
insert into ChiTietGhe values(780,'PC08','g80');
insert into ChiTietGhe values(781,'PC08','g81');
insert into ChiTietGhe values(782,'PC08','g82');
insert into ChiTietGhe values(783,'PC08','g83');
insert into ChiTietGhe values(784,'PC08','g84');
insert into ChiTietGhe values(785,'PC08','g85');
insert into ChiTietGhe values(786,'PC08','g86');
insert into ChiTietGhe values(787,'PC08','g87');
insert into ChiTietGhe values(788,'PC08','g88');
insert into ChiTietGhe values(789,'PC08','g89');
insert into ChiTietGhe values(790,'PC08','g90');
insert into ChiTietGhe values(791,'PC08','g91');
insert into ChiTietGhe values(792,'PC08','g92');
insert into ChiTietGhe values(793,'PC08','g93');
insert into ChiTietGhe values(794,'PC08','g94');
insert into ChiTietGhe values(795,'PC08','g95');
insert into ChiTietGhe values(796,'PC08','g96');
insert into ChiTietGhe values(797,'PC08','g97');
insert into ChiTietGhe values(798,'PC08','g98');
insert into ChiTietGhe values(799,'PC08','g99');
insert into ChiTietGhe values(800,'PC08','g100');
insert into ChiTietGhe values(801,'PC08','g101');
insert into ChiTietGhe values(802,'PC08','g102');
insert into ChiTietGhe values(803,'PC08','g103');
insert into ChiTietGhe values(804,'PC08','g104');
insert into ChiTietGhe values(805,'PC08','g105');
insert into ChiTietGhe values(806,'PC08','g106');
insert into ChiTietGhe values(807,'PC08','g107');
insert into ChiTietGhe values(808,'PC08','g108');
insert into ChiTietGhe values(809,'PC08','g109');
insert into ChiTietGhe values(810,'PC08','g110');
insert into ChiTietGhe values(811,'PC09','g1');
insert into ChiTietGhe values(812,'PC09','g2');
insert into ChiTietGhe values(813,'PC09','g3');
insert into ChiTietGhe values(814,'PC09','g4');
insert into ChiTietGhe values(815,'PC09','g5');
insert into ChiTietGhe values(816,'PC09','g6');
insert into ChiTietGhe values(817,'PC09','g7');
insert into ChiTietGhe values(818,'PC09','g8');
insert into ChiTietGhe values(819,'PC09','g9');
insert into ChiTietGhe values(820,'PC09','g10');
insert into ChiTietGhe values(821,'PC09','g11');
insert into ChiTietGhe values(822,'PC09','g12');
insert into ChiTietGhe values(823,'PC09','g13');
insert into ChiTietGhe values(824,'PC09','g14');
insert into ChiTietGhe values(825,'PC09','g15');
insert into ChiTietGhe values(826,'PC09','g16');
insert into ChiTietGhe values(827,'PC09','g17');
insert into ChiTietGhe values(828,'PC09','g18');
insert into ChiTietGhe values(829,'PC09','g19');
insert into ChiTietGhe values(830,'PC09','g20');
insert into ChiTietGhe values(831,'PC09','g21');
insert into ChiTietGhe values(832,'PC09','g22');
insert into ChiTietGhe values(833,'PC09','g23');
insert into ChiTietGhe values(834,'PC09','g24');
insert into ChiTietGhe values(835,'PC09','g25');
insert into ChiTietGhe values(836,'PC09','g26');
insert into ChiTietGhe values(837,'PC09','g27');
insert into ChiTietGhe values(838,'PC09','g28');
insert into ChiTietGhe values(839,'PC09','g29');
insert into ChiTietGhe values(840,'PC09','g30');
insert into ChiTietGhe values(841,'PC09','g31');
insert into ChiTietGhe values(842,'PC09','g32');
insert into ChiTietGhe values(843,'PC09','g33');
insert into ChiTietGhe values(844,'PC09','g34');
insert into ChiTietGhe values(845,'PC09','g35');
insert into ChiTietGhe values(846,'PC09','g36');
insert into ChiTietGhe values(847,'PC09','g37');
insert into ChiTietGhe values(848,'PC09','g38');
insert into ChiTietGhe values(849,'PC09','g39');
insert into ChiTietGhe values(850,'PC09','g40');
insert into ChiTietGhe values(851,'PC09','g41');
insert into ChiTietGhe values(852,'PC09','g42');
insert into ChiTietGhe values(853,'PC09','g43');
insert into ChiTietGhe values(854,'PC09','g44');
insert into ChiTietGhe values(855,'PC09','g45');
insert into ChiTietGhe values(856,'PC09','g46');
insert into ChiTietGhe values(857,'PC09','g47');
insert into ChiTietGhe values(858,'PC09','g48');
insert into ChiTietGhe values(859,'PC09','g49');
insert into ChiTietGhe values(860,'PC09','g50');
insert into ChiTietGhe values(861,'PC09','g51');
insert into ChiTietGhe values(862,'PC09','g52');
insert into ChiTietGhe values(863,'PC09','g53');
insert into ChiTietGhe values(864,'PC09','g54');
insert into ChiTietGhe values(865,'PC09','g55');
insert into ChiTietGhe values(866,'PC09','g56');
insert into ChiTietGhe values(867,'PC09','g57');
insert into ChiTietGhe values(868,'PC09','g58');
insert into ChiTietGhe values(869,'PC09','g59');
insert into ChiTietGhe values(870,'PC09','g60');
insert into ChiTietGhe values(871,'PC09','g61');
insert into ChiTietGhe values(872,'PC09','g62');
insert into ChiTietGhe values(873,'PC09','g63');
insert into ChiTietGhe values(874,'PC09','g64');
insert into ChiTietGhe values(875,'PC09','g65');
insert into ChiTietGhe values(876,'PC09','g66');
insert into ChiTietGhe values(877,'PC09','g67');
insert into ChiTietGhe values(878,'PC09','g68');
insert into ChiTietGhe values(879,'PC09','g69');
insert into ChiTietGhe values(880,'PC09','g70');
insert into ChiTietGhe values(881,'PC09','g71');
insert into ChiTietGhe values(882,'PC09','g72');
insert into ChiTietGhe values(883,'PC09','g73');
insert into ChiTietGhe values(884,'PC09','g74');
insert into ChiTietGhe values(885,'PC09','g75');
insert into ChiTietGhe values(886,'PC09','g76');
insert into ChiTietGhe values(887,'PC09','g77');
insert into ChiTietGhe values(888,'PC09','g78');
insert into ChiTietGhe values(889,'PC09','g79');
insert into ChiTietGhe values(890,'PC09','g80');
insert into ChiTietGhe values(891,'PC09','g81');
insert into ChiTietGhe values(892,'PC09','g82');
insert into ChiTietGhe values(893,'PC09','g83');
insert into ChiTietGhe values(894,'PC09','g84');
insert into ChiTietGhe values(895,'PC09','g85');
insert into ChiTietGhe values(896,'PC09','g86');
insert into ChiTietGhe values(897,'PC09','g87');
insert into ChiTietGhe values(898,'PC09','g88');
insert into ChiTietGhe values(899,'PC09','g89');
insert into ChiTietGhe values(900,'PC09','g90');
insert into ChiTietGhe values(901,'PC09','g91');
insert into ChiTietGhe values(902,'PC09','g92');
insert into ChiTietGhe values(903,'PC09','g93');
insert into ChiTietGhe values(904,'PC09','g94');
insert into ChiTietGhe values(905,'PC09','g95');
insert into ChiTietGhe values(906,'PC09','g96');
insert into ChiTietGhe values(907,'PC09','g97');
insert into ChiTietGhe values(908,'PC09','g98');
insert into ChiTietGhe values(909,'PC09','g99');
insert into ChiTietGhe values(910,'PC09','g100');
insert into ChiTietGhe values(911,'PC09','g101');
insert into ChiTietGhe values(912,'PC09','g102');
insert into ChiTietGhe values(913,'PC09','g103');
insert into ChiTietGhe values(914,'PC09','g104');
insert into ChiTietGhe values(915,'PC09','g105');
insert into ChiTietGhe values(916,'PC09','g106');
insert into ChiTietGhe values(917,'PC09','g107');
insert into ChiTietGhe values(918,'PC09','g108');
insert into ChiTietGhe values(919,'PC09','g109');
insert into ChiTietGhe values(920,'PC09','g110');
insert into ChiTietGhe values(921,'PC10','g1');
insert into ChiTietGhe values(922,'PC10','g2');
insert into ChiTietGhe values(923,'PC10','g3');
insert into ChiTietGhe values(924,'PC10','g4');
insert into ChiTietGhe values(925,'PC10','g5');
insert into ChiTietGhe values(926,'PC10','g6');
insert into ChiTietGhe values(927,'PC10','g7');
insert into ChiTietGhe values(928,'PC10','g8');
insert into ChiTietGhe values(929,'PC10','g9');
insert into ChiTietGhe values(930,'PC10','g10');
insert into ChiTietGhe values(931,'PC10','g11');
insert into ChiTietGhe values(932,'PC10','g12');
insert into ChiTietGhe values(933,'PC10','g13');
insert into ChiTietGhe values(934,'PC10','g14');
insert into ChiTietGhe values(935,'PC10','g15');
insert into ChiTietGhe values(936,'PC10','g16');
insert into ChiTietGhe values(937,'PC10','g17');
insert into ChiTietGhe values(938,'PC10','g18');
insert into ChiTietGhe values(939,'PC10','g19');
insert into ChiTietGhe values(940,'PC10','g20');
insert into ChiTietGhe values(941,'PC10','g21');
insert into ChiTietGhe values(942,'PC10','g22');
insert into ChiTietGhe values(943,'PC10','g23');
insert into ChiTietGhe values(944,'PC10','g24');
insert into ChiTietGhe values(945,'PC10','g25');
insert into ChiTietGhe values(946,'PC10','g26');
insert into ChiTietGhe values(947,'PC10','g27');
insert into ChiTietGhe values(948,'PC10','g28');
insert into ChiTietGhe values(949,'PC10','g29');
insert into ChiTietGhe values(950,'PC10','g30');
insert into ChiTietGhe values(951,'PC10','g31');
insert into ChiTietGhe values(952,'PC10','g32');
insert into ChiTietGhe values(953,'PC10','g33');
insert into ChiTietGhe values(954,'PC10','g34');
insert into ChiTietGhe values(955,'PC10','g35');
insert into ChiTietGhe values(956,'PC10','g36');
insert into ChiTietGhe values(957,'PC10','g37');
insert into ChiTietGhe values(958,'PC10','g38');
insert into ChiTietGhe values(959,'PC10','g39');
insert into ChiTietGhe values(960,'PC10','g40');
insert into ChiTietGhe values(961,'PC10','g41');
insert into ChiTietGhe values(962,'PC10','g42');
insert into ChiTietGhe values(963,'PC10','g43');
insert into ChiTietGhe values(964,'PC10','g44');
insert into ChiTietGhe values(965,'PC10','g45');
insert into ChiTietGhe values(966,'PC10','g46');
insert into ChiTietGhe values(967,'PC10','g47');
insert into ChiTietGhe values(968,'PC10','g48');
insert into ChiTietGhe values(969,'PC10','g49');
insert into ChiTietGhe values(970,'PC10','g50');
insert into ChiTietGhe values(971,'PC10','g51');
insert into ChiTietGhe values(972,'PC10','g52');
insert into ChiTietGhe values(973,'PC10','g53');
insert into ChiTietGhe values(974,'PC10','g54');
insert into ChiTietGhe values(975,'PC10','g55');
insert into ChiTietGhe values(976,'PC10','g56');
insert into ChiTietGhe values(977,'PC10','g57');
insert into ChiTietGhe values(978,'PC10','g58');
insert into ChiTietGhe values(979,'PC10','g59');
insert into ChiTietGhe values(980,'PC10','g60');
insert into ChiTietGhe values(981,'PC10','g61');
insert into ChiTietGhe values(982,'PC10','g62');
insert into ChiTietGhe values(983,'PC10','g63');
insert into ChiTietGhe values(984,'PC10','g64');
insert into ChiTietGhe values(985,'PC10','g65');
insert into ChiTietGhe values(986,'PC10','g66');
insert into ChiTietGhe values(987,'PC10','g67');
insert into ChiTietGhe values(988,'PC10','g68');
insert into ChiTietGhe values(989,'PC10','g69');
insert into ChiTietGhe values(990,'PC10','g70');
insert into ChiTietGhe values(991,'PC10','g71');
insert into ChiTietGhe values(992,'PC10','g72');
insert into ChiTietGhe values(993,'PC10','g73');
insert into ChiTietGhe values(994,'PC10','g74');
insert into ChiTietGhe values(995,'PC10','g75');
insert into ChiTietGhe values(996,'PC10','g76');
insert into ChiTietGhe values(997,'PC10','g77');
insert into ChiTietGhe values(998,'PC10','g78');
insert into ChiTietGhe values(999,'PC10','g79');
insert into ChiTietGhe values(1000,'PC10','g80');
insert into ChiTietGhe values(1001,'PC10','g81');
insert into ChiTietGhe values(1002,'PC10','g82');
insert into ChiTietGhe values(1003,'PC10','g83');
insert into ChiTietGhe values(1004,'PC10','g84');
insert into ChiTietGhe values(1005,'PC10','g85');
insert into ChiTietGhe values(1006,'PC10','g86');
insert into ChiTietGhe values(1007,'PC10','g87');
insert into ChiTietGhe values(1008,'PC10','g88');
insert into ChiTietGhe values(1009,'PC10','g89');
insert into ChiTietGhe values(1010,'PC10','g90');
insert into ChiTietGhe values(1011,'PC10','g91');
insert into ChiTietGhe values(1012,'PC10','g92');
insert into ChiTietGhe values(1013,'PC10','g93');
insert into ChiTietGhe values(1014,'PC10','g94');
insert into ChiTietGhe values(1015,'PC10','g95');
insert into ChiTietGhe values(1016,'PC10','g96');
insert into ChiTietGhe values(1017,'PC10','g97');
insert into ChiTietGhe values(1018,'PC10','g98');
insert into ChiTietGhe values(1019,'PC10','g99');
insert into ChiTietGhe values(1020,'PC10','g100');
insert into ChiTietGhe values(1021,'PC10','g101');
insert into ChiTietGhe values(1022,'PC10','g102');
insert into ChiTietGhe values(1023,'PC10','g103');
insert into ChiTietGhe values(1024,'PC10','g104');
insert into ChiTietGhe values(1025,'PC10','g105');
insert into ChiTietGhe values(1026,'PC10','g106');
insert into ChiTietGhe values(1027,'PC10','g107');
insert into ChiTietGhe values(1028,'PC10','g108');
insert into ChiTietGhe values(1029,'PC10','g109');
insert into ChiTietGhe values(1030,'PC10','g110');

insert into ChiTietGhe values(1031,'PC11','g1');
insert into ChiTietGhe values(1032,'PC11','g2');
insert into ChiTietGhe values(1033,'PC11','g3');
insert into ChiTietGhe values(1034,'PC11','g4');
insert into ChiTietGhe values(1035,'PC11','g5');
insert into ChiTietGhe values(1036,'PC11','g6');
insert into ChiTietGhe values(1037,'PC11','g7');
insert into ChiTietGhe values(1038,'PC11','g8');
insert into ChiTietGhe values(1039,'PC11','g9');
insert into ChiTietGhe values(1040,'PC11','g10');
insert into ChiTietGhe values(1041,'PC11','g11');
insert into ChiTietGhe values(1042,'PC11','g12');
insert into ChiTietGhe values(1043,'PC11','g13');
insert into ChiTietGhe values(1044,'PC11','g14');
insert into ChiTietGhe values(1045,'PC11','g15');
insert into ChiTietGhe values(1046,'PC11','g16');
insert into ChiTietGhe values(1047,'PC11','g17');
insert into ChiTietGhe values(1048,'PC11','g18');
insert into ChiTietGhe values(1049,'PC11','g19');
insert into ChiTietGhe values(1050,'PC11','g20');
insert into ChiTietGhe values(1051,'PC11','g21');
insert into ChiTietGhe values(1052,'PC11','g22');
insert into ChiTietGhe values(1053,'PC11','g23');
insert into ChiTietGhe values(1054,'PC11','g24');
insert into ChiTietGhe values(1055,'PC11','g25');
insert into ChiTietGhe values(1056,'PC11','g26');
insert into ChiTietGhe values(1057,'PC11','g27');
insert into ChiTietGhe values(1058,'PC11','g28');
insert into ChiTietGhe values(1059,'PC11','g29');
insert into ChiTietGhe values(1060,'PC11','g30');
insert into ChiTietGhe values(1061,'PC11','g31');
insert into ChiTietGhe values(1062,'PC11','g32');
insert into ChiTietGhe values(1063,'PC11','g33');
insert into ChiTietGhe values(1064,'PC11','g34');
insert into ChiTietGhe values(1065,'PC11','g35');
insert into ChiTietGhe values(1066,'PC11','g36');
insert into ChiTietGhe values(1067,'PC11','g37');
insert into ChiTietGhe values(1068,'PC11','g38');
insert into ChiTietGhe values(1069,'PC11','g39');
insert into ChiTietGhe values(1070,'PC11','g40');
insert into ChiTietGhe values(1071,'PC11','g41');
insert into ChiTietGhe values(1072,'PC11','g42');
insert into ChiTietGhe values(1073,'PC11','g43');
insert into ChiTietGhe values(1074,'PC11','g44');
insert into ChiTietGhe values(1075,'PC11','g45');
insert into ChiTietGhe values(1076,'PC11','g46');
insert into ChiTietGhe values(1077,'PC11','g47');
insert into ChiTietGhe values(1078,'PC11','g48');
insert into ChiTietGhe values(1079,'PC11','g49');
insert into ChiTietGhe values(1080,'PC11','g50');
insert into ChiTietGhe values(1081,'PC11','g51');
insert into ChiTietGhe values(1082,'PC11','g52');
insert into ChiTietGhe values(1083,'PC11','g53');
insert into ChiTietGhe values(1084,'PC11','g54');
insert into ChiTietGhe values(1085,'PC11','g55');
insert into ChiTietGhe values(1086,'PC11','g56');
insert into ChiTietGhe values(1087,'PC11','g57');
insert into ChiTietGhe values(1088,'PC11','g58');
insert into ChiTietGhe values(1089,'PC11','g59');
insert into ChiTietGhe values(1090,'PC11','g60');
insert into ChiTietGhe values(1091,'PC11','g61');
insert into ChiTietGhe values(1092,'PC11','g62');
insert into ChiTietGhe values(1093,'PC11','g63');
insert into ChiTietGhe values(1094,'PC11','g64');
insert into ChiTietGhe values(1095,'PC11','g65');
insert into ChiTietGhe values(1096,'PC11','g66');
insert into ChiTietGhe values(1097,'PC11','g67');
insert into ChiTietGhe values(1098,'PC11','g68');
insert into ChiTietGhe values(1099,'PC11','g69');
insert into ChiTietGhe values(1100,'PC11','g70');
insert into ChiTietGhe values(1101,'PC11','g71');
insert into ChiTietGhe values(1102,'PC11','g72');
insert into ChiTietGhe values(1103,'PC11','g73');
insert into ChiTietGhe values(1104,'PC11','g74');
insert into ChiTietGhe values(1105,'PC11','g75');
insert into ChiTietGhe values(1106,'PC11','g76');
insert into ChiTietGhe values(1107,'PC11','g77');
insert into ChiTietGhe values(1108,'PC11','g78');
insert into ChiTietGhe values(1109,'PC11','g79');
insert into ChiTietGhe values(1110,'PC11','g80');
insert into ChiTietGhe values(1111,'PC11','g81');
insert into ChiTietGhe values(1112,'PC11','g82');
insert into ChiTietGhe values(1113,'PC11','g83');
insert into ChiTietGhe values(1114,'PC11','g84');
insert into ChiTietGhe values(1115,'PC11','g85');
insert into ChiTietGhe values(1116,'PC11','g86');
insert into ChiTietGhe values(1117,'PC11','g87');
insert into ChiTietGhe values(1118,'PC11','g88');
insert into ChiTietGhe values(1119,'PC11','g89');
insert into ChiTietGhe values(1120,'PC11','g90');
insert into ChiTietGhe values(1121,'PC11','g91');
insert into ChiTietGhe values(1122,'PC11','g92');
insert into ChiTietGhe values(1123,'PC11','g93');
insert into ChiTietGhe values(1124,'PC11','g94');
insert into ChiTietGhe values(1125,'PC11','g95');
insert into ChiTietGhe values(1126,'PC11','g96');

insert into ChiTietGhe values(1127,'PC12','g1');
insert into ChiTietGhe values(1128,'PC12','g2');
insert into ChiTietGhe values(1129,'PC12','g3');
insert into ChiTietGhe values(1130,'PC12','g4');
insert into ChiTietGhe values(1131,'PC12','g5');
insert into ChiTietGhe values(1132,'PC12','g6');
insert into ChiTietGhe values(1133,'PC12','g7');
insert into ChiTietGhe values(1134,'PC12','g8');
insert into ChiTietGhe values(1135,'PC12','g9');
insert into ChiTietGhe values(1136,'PC12','g10');
insert into ChiTietGhe values(1137,'PC12','g11');
insert into ChiTietGhe values(1138,'PC12','g12');
insert into ChiTietGhe values(1139,'PC12','g13');
insert into ChiTietGhe values(1140,'PC12','g14');
insert into ChiTietGhe values(1141,'PC12','g15');
insert into ChiTietGhe values(1142,'PC12','g16');
insert into ChiTietGhe values(1143,'PC12','g17');
insert into ChiTietGhe values(1144,'PC12','g18');
insert into ChiTietGhe values(1145,'PC12','g19');
insert into ChiTietGhe values(1146,'PC12','g20');
insert into ChiTietGhe values(1147,'PC12','g21');
insert into ChiTietGhe values(1148,'PC12','g22');
insert into ChiTietGhe values(1149,'PC12','g23');
insert into ChiTietGhe values(1150,'PC12','g24');
insert into ChiTietGhe values(1151,'PC12','g25');
insert into ChiTietGhe values(1152,'PC12','g26');
insert into ChiTietGhe values(1153,'PC12','g27');
insert into ChiTietGhe values(1154,'PC12','g28');
insert into ChiTietGhe values(1155,'PC12','g29');
insert into ChiTietGhe values(1156,'PC12','g30');
insert into ChiTietGhe values(1157,'PC12','g31');
insert into ChiTietGhe values(1158,'PC12','g32');
insert into ChiTietGhe values(1159,'PC12','g33');
insert into ChiTietGhe values(1160,'PC12','g34');
insert into ChiTietGhe values(1161,'PC12','g35');
insert into ChiTietGhe values(1162,'PC12','g36');
insert into ChiTietGhe values(1163,'PC12','g37');
insert into ChiTietGhe values(1164,'PC12','g38');
insert into ChiTietGhe values(1165,'PC12','g39');
insert into ChiTietGhe values(1166,'PC12','g40');
insert into ChiTietGhe values(1167,'PC12','g41');
insert into ChiTietGhe values(1168,'PC12','g42');
insert into ChiTietGhe values(1169,'PC12','g43');
insert into ChiTietGhe values(1170,'PC12','g44');
insert into ChiTietGhe values(1171,'PC12','g45');
insert into ChiTietGhe values(1172,'PC12','g46');
insert into ChiTietGhe values(1173,'PC12','g47');
insert into ChiTietGhe values(1174,'PC12','g48');
insert into ChiTietGhe values(1175,'PC12','g49');
insert into ChiTietGhe values(1176,'PC12','g50');
insert into ChiTietGhe values(1177,'PC12','g51');
insert into ChiTietGhe values(1178,'PC12','g52');
insert into ChiTietGhe values(1179,'PC12','g53');
insert into ChiTietGhe values(1180,'PC12','g54');
insert into ChiTietGhe values(1181,'PC12','g55');
insert into ChiTietGhe values(1182,'PC12','g56');
insert into ChiTietGhe values(1183,'PC12','g57');
insert into ChiTietGhe values(1184,'PC12','g58');
insert into ChiTietGhe values(1185,'PC12','g59');
insert into ChiTietGhe values(1186,'PC12','g60');
insert into ChiTietGhe values(1187,'PC12','g61');
insert into ChiTietGhe values(1188,'PC12','g62');
insert into ChiTietGhe values(1189,'PC12','g63');
insert into ChiTietGhe values(1190,'PC12','g64');
insert into ChiTietGhe values(1191,'PC12','g65');
insert into ChiTietGhe values(1192,'PC12','g66');
insert into ChiTietGhe values(1193,'PC12','g67');
insert into ChiTietGhe values(1194,'PC12','g68');
insert into ChiTietGhe values(1195,'PC12','g69');
insert into ChiTietGhe values(1196,'PC12','g70');
insert into ChiTietGhe values(1197,'PC12','g71');
insert into ChiTietGhe values(1198,'PC12','g72');
insert into ChiTietGhe values(1199,'PC12','g73');
insert into ChiTietGhe values(1200,'PC12','g74');
insert into ChiTietGhe values(1201,'PC12','g75');
insert into ChiTietGhe values(1202,'PC12','g76');
insert into ChiTietGhe values(1203,'PC12','g77');
insert into ChiTietGhe values(1204,'PC12','g78');
insert into ChiTietGhe values(1205,'PC12','g79');
insert into ChiTietGhe values(1206,'PC12','g80');
insert into ChiTietGhe values(1207,'PC12','g81');
insert into ChiTietGhe values(1208,'PC12','g82');
insert into ChiTietGhe values(1209,'PC12','g83');
insert into ChiTietGhe values(1210,'PC12','g84');
insert into ChiTietGhe values(1211,'PC12','g85');
insert into ChiTietGhe values(1212,'PC12','g86');
insert into ChiTietGhe values(1213,'PC12','g87');
insert into ChiTietGhe values(1214,'PC12','g88');
insert into ChiTietGhe values(1215,'PC12','g89');
insert into ChiTietGhe values(1216,'PC12','g90');
insert into ChiTietGhe values(1217,'PC12','g91');
insert into ChiTietGhe values(1218,'PC12','g92');
insert into ChiTietGhe values(1219,'PC12','g93');
insert into ChiTietGhe values(1220,'PC12','g94');
insert into ChiTietGhe values(1221,'PC12','g95');
insert into ChiTietGhe values(1222,'PC12','g96');

insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,1,1,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,2,2,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,3,3,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,4,4,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,5,5,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,6,6,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,7,7,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,8,8,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,9,9,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,10,10,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,11,11,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,12,12,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,13,13,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,14,14,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,15,15,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,1,16,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,2,17,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,3,18,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,4,19,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,5,20,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,6,21,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,7,22,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,8,23,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,9,24,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,10,25,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,11,26,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,12,27,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,13,28,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,14,29,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,15,30,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,1,31,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,2,32,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,3,33,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,4,34,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,5,35,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,6,36,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,7,37,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,8,38,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,9,39,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,10,40,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,11,41,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,12,42,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,13,43,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,14,44,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,15,45,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,1,46,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,2,47,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,3,48,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,4,49,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,5,50,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,6,51,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,7,52,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,8,53,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,9,54,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,10,55,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,11,56,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,12,57,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,13,58,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,14,59,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,15,60,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,1,61,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,2,62,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,3,63,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,4,64,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,5,65,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,6,66,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,7,67,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,8,68,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,9,69,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,10,70,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,11,71,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,12,72,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,13,73,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,14,74,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,15,75,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,1,76,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,2,77,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,3,78,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,4,79,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,5,80,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,6,81,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,7,82,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,8,83,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,9,84,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,10,85,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,11,86,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,12,87,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,13,88,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,14,89,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,15,90,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,1,91,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,2,92,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,3,93,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,4,94,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,5,95,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,6,96,1);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,7,97,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,8,98,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,9,99,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,10,100,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,11,101,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,12,102,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,13,103,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,14,104,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,15,105,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,1,106,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,2,107,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,3,108,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,4,109,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,5,110,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,6,111,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,7,112,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,8,113,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,9,114,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,10,115,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,11,116,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,12,117,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,13,118,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,14,119,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,15,120,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,1,121,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,2,122,2);
insert into VE(ThueVAT,MaKH,MaCTGhe,Stt_XC) values(0.05,3,123,2);											

insert into Topping values('tp01','Bắp rang bơ',20,60000,'tp01.jpg');
insert into Topping values('tp02','Coca Cola',50,79000,'tp02.jpg');
insert into Topping values('tp03','Sting',70,39000,'tp03.jpg');
insert into Topping values('tp04','Lẩu ly',33,55000,'tp04.jpg');

insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','10:00:00','18:00:00',25000,'NV01','cn1');
insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','10:00:00','18:00:00',25000,'NV02','cn1');
insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','10:00:00','18:00:00',25000,'NV03','cn1');
insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','10:00:00','18:00:00',25000,'NV04','cn1');
insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','10:00:00','18:00:00',25000,'NV05','cn1');
insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','10:00:00','18:00:00',25000,'NV06','cn1');
insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','18:00:00','23:59:59',25000,'NV07','cn1');
insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','18:00:00','23:59:59',25000,'NV08','cn1');
insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','18:00:00','23:59:59',25000,'NV09','cn1');
insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','18:00:00','23:59:59',25000,'NV10','cn1');
insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','18:00:00','23:59:59',25000,'NV11','cn1');
insert into LichLamViec (NgayLam,ThoiGianBatDau,ThoiGianKetThuc,LuongCoBan,MaNV,MaCN) values('2022-11-07','18:00:00','23:59:59',25000,'NV12','cn1');


insert into ChiTietTopping values(1,'tp01',1);
insert into ChiTietTopping values(2,'tp01',2);

-- create or replace function fillCard(
-- 	ngayvo date
-- )
-- returns table(
-- 	TenPhim text,
	
-- )
-- LANGUAGE 'plpgsql'
-- as $body$
-- begin
-- return query SELECT P.TENPHONG,
-- 	COUNT(CTG.MACTGHE) SOGHE,
-- 	COUNT(V.MACTGHE) SOVE
-- FROM PHONGCHIEU P
-- RIGHT JOIN CHITIETGHE CTG ON CTG.MAPHONG = P.MAPHONG
-- LEFT JOIN VE V ON V.MACTGHE = CTG.MACTGHE
-- WHERE P.MAPHONG in
-- 		(SELECT P.MAPHONG
-- 			FROM PHONGCHIEU P
-- 			JOIN XUATCHIEU XC ON XC.MAPHONG = P.MAPHONG
-- 			WHERE XC.ngay = ngayvo)
-- GROUP BY P.TENPHONG; 
-- END ;

-- select p.tenphim
-- from XuatChieu xc join Phim p on p.maphim = xc.maphim
-- where xc.ngay = '2022-09-01';
-- union
-- select GioBatDau,n.STT from XuatChieu xc join NgayChieu n on n.STT = xc.STT and n.Ngay = xc.Ngay
-- where maphim = 'MP01' and xc.ngay = '2022-09-01'
-- create or replace function getCountVe(
-- 	MaPhim text,
-- 	ngay date,
-- 	STT int
-- )

-- RETURNs table(
-- 	SoGhe bigint
-- )
-- language 'plpgsql'
-- as $$
-- begin
-- return query select v.MaCTGhe, g.TenGhe
-- from Ve v join ChiTietGhe ctg on v.MaCTGhe = ctg.MaCTGhe
-- 			join PhongChieu pg on pg.MaPhong = ctg.MaPhong
-- 			join XuatChieu xc on xc.MaPhong = pg.MaPhong
-- 			join NgayChieu n on n.STT = xc.STT and n.Ngay = xc.Ngay
-- 			right join Phim p on p.MaPhim = xc.MaPhim
-- 			join Ghe g on g.MaGhe = ctg.MaGhe
-- where p.MaPhim = MaPhim and xc.ngay = ngay and xc.STT = STT;
-- end $$;
-- -- select * from Phim
-- select v.MaCTGhe, g.TenGhe
-- from Ve v join ChiTietGhe ctg on v.MaCTGhe = ctg.MaCTGhe
-- 			join PhongChieu pg on pg.MaPhong = ctg.MaPhong
-- 			join XuatChieu xc on xc.MaPhong = pg.MaPhong
-- 			join NgayChieu n on n.STT = xc.STT and n.Ngay = xc.Ngay
-- 			right join Phim p on p.MaPhim = xc.MaPhim
-- 			join Ghe g on g.MaGhe = ctg.MaGhe
-- where p.MaPhim = 'MP02' and xc.ngay = '2022-09-01' and xc.STT = 1
-- ;

-- drop function SelectGheInVe
create or replace function SelectGheInVe(
	ngayvo date,
	sttvo bigint,
	maphimvo character varying
)

returns table (
	MaCTGhe int,
	Tenghe CHARACTER varying
)
LANGUAGE 'plpgsql'
as $$
begin
	return query select v.MaCTGhe , cast(g.TenGhe as character varying ) as TenGhe
from ve v join ChiTietGhe ctg on v.MaCTGhe = ctg.MaCTGhe
join ghe g on g.maghe = ctg.maghe
			join phongchieu pc ON pc.maphong = ctg.maphong
			join XuatChieu xc on xc.maphong = pc.maphong
			join Phim p on p.maphim = xc.maphim
where xc.ngay = ngayvo and xc.stt = sttvo and p.maphim = maphimvo;
end $$;
with t as (
  -- Any generic query which returns rowid and corresponding calculated values
  select distinct ve.idve as id1,(phuthu+giaxuatchieu)* 1.05 + (case when chitiettopping.idve  is null then 0 else chitiettopping.soluongmua*topping.gia end) as tong			
  from ve  JOIN chitietghe ON chitietghe.mactghe = ve.mactghe
			join phongchieu ON phongchieu.maphong = chitietghe.maphong
			join xuatchieu ON xuatchieu.maphong = phongchieu.maphong
			left join chitiettopping ON chitiettopping.idve = ve.idve
			left join topping ON topping.matopping = chitiettopping.matopping
			join ghe on ghe.maghe = chitietghe.maghe
			join loaighe on loaighe.maloai = ghe.maloai

)
update ve
set tonggiave = t.tong
from t
where idve = t.id1;
-- select Ve.idve, loaighe.tenloai, phuthu, xc.giaxuatchieu,soluongmua, t.gia
-- from Ve left join chitiettopping ctt on ctt.idve = Ve.idve
-- 		join chitietghe ON chitietghe.mactghe = Ve.mactghe
-- 		left join topping t on t.matopping = ctt.matopping
-- 		join PhongChieu pc on chitietghe.maphong = pc.maphong
-- 		join XuatChieu xc on xc.maphong = pc.maphong
-- 		join ghe on ghe.maghe = chitietghe.maghe
-- 		join loaighe on loaighe.maloai = ghe.maloai;
		
-- select * from NgayChieu where giobatdau <= '17:00:00'
-- select * from SelectGheInVe('2022-09-01',1,'MP02')
-- select p.TenPhim from Phim p join XuatChieu xc on xc.MaPhim = p.MaPhim
-- select Phim.*  
-- from Phim join xuatchieu ON xuatchieu.maphim = Phim.maphim
-- 		join phongchieu ON phongchieu.maphong = xuatchieu.maphong
-- 		join chinhanh ON chinhanh.macn = phongchieu.macn
-- 		join ngaychieu on ngaychieu.stt = xuatchieu.ngay
-- where chinhanh.macn = 'cn1' and ngaychieu.ngay = CURRENT_DATE
-- select * from SelectPhimByChiNhanh('cn2');

create or replace function SelectPhimByChiNhanh(
	cn varchar(5)
)

returns table (
	MaPhim varchar(5),
	TenPhim text,
	DienVien text,
	NamSX int,
	Hinh text,
	DaoDien text,
	QuocGia text,
	ThoiLuong text,
	MoTa text,
	Traller text
)
LANGUAGE 'plpgsql'
as $$
begin
	return query select Phim.*  
from Phim join xuatchieu ON xuatchieu.maphim = Phim.maphim
		join phongchieu ON phongchieu.maphong = xuatchieu.maphong
		join chinhanh ON chinhanh.macn = phongchieu.macn
		join ngaychieu on ngaychieu.stt = xuatchieu.ngay
where chinhanh.macn = cn and ngaychieu.ngay = CURRENT_DATE;
end $$;


create or replace function SelectGio()

returns table (
	 stt int,
	ngay date,
	giobatdau time
)

LANGUAGE 'plpgsql'
as $$
begin
	return query select NgayChieu.*  
from NgayChieu
where NgayChieu.ngay = CURRENT_DATE and NgayChieu.giobatdau >cast( to_char(now(), 'HH24:MI:SS') as time);
end $$;



-- SELECT CURRENT_TIMESTAMP;

-- select  to_char(now(), 'HH24:MI:SS')



-- select ngaychieu.ngay, ngaychieu.giobatdau ,phim.tenphim from phim join xuatchieu on phim.maphim=xuatchieu.maphim
-- 				   join ngaychieu on ngaychieu.stt=xuatchieu.stt
-- 	 where ngaychieu.giobatdau = '13:30:00' and ngaychieu.ngay=CURRENT_DATE 
	 

create or replace function SelectTenPhim(
	gio time
)
	
returns table (
	MaPhim varchar(5),
	TenPhim text,
	DienVien text,
	NamSX int,
	Hinh text,
	DaoDien text,
	QuocGia text,
	ThoiLuong text,
	MoTa text,
	Traller text	
)

LANGUAGE 'plpgsql'
as $$
begin
	return query select phim.*
	from phim join xuatchieu on phim.maphim=xuatchieu.maphim
			  join ngaychieu on ngaychieu.stt=xuatchieu.stt
	 where ngaychieu.giobatdau = gio and ngaychieu.ngay=CURRENT_DATE;
end $$;

create or replace function Selectghecove(
	maPhimChieu varchar(5),
	sttngay int,
	giobatdauchieu time
)
	
returns table (
	MaLoaiGhe int,
	maGhe varchar(5),
	tenGheA varchar(5),
	idVe int,
	gia float,
	maCTghe int
)

LANGUAGE 'plpgsql'
as $$
begin
	return query SELECT Ghe.MaLoai,Ghe.MaGhe,TenGhe,ve.IdVe, (LoaiGhe.phuthu+XuatChieu.giaxuatchieu) as gia, ChiTietGhe.MaCTGhe
		FROM ChiTietGhe JOIN Ghe on Ghe.MaGhe = ChiTietGhe.MaGhe
						join PhongChieu on PhongChieu.MaPhong = ChiTietGhe.MaPhong
						join XuatChieu on  XuatChieu.MaPhong = PhongChieu.MaPhong
						join NgayChieu on NgayChieu.stt = XuatChieu.stt
						left join ve ON ve.mactghe = ChiTietGhe.mactghe
						join LoaiGhe on LoaiGhe.MaLoai = Ghe.MaLoai
		WHERE MaPhim = maPhimChieu and NgayChieu.stt = sttngay and NgayChieu.GioBatDau = giobatdauchieu
		order by ChiTietGhe.mactghe;
end $$;
-- select * from SelectTenPhim('18:00:00')
-- select MaPhong from xuatchieu where MaPhim ='MP06' and ngay = 39
						
-- select ChiTietGhe.maphong,TenGhe,MaCTGhe,Ghe.MaGhe,(loaighe.phuthu+ xuatchieu.giaxuatchieu) as gia from ChiTietGhe join Ghe on Ghe.MaGhe=ChiTietGhe.MaGhe join loaighe ON loaighe.maloai = Ghe.maloai join phongchieu ON phongchieu.maphong = ChiTietGhe.maphong join xuatchieu ON xuatchieu.maphong = phongchieu.maphong where ChiTietGhe.MaPhong = 'PC12' and xuatchieu.stt =39