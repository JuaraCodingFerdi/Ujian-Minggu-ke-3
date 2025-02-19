# TestNG Selenium Automation

## Deskripsi

Project ini adalah pengujian otomatisasi menggunakan Selenium dan TestNG untuk mengelola kategori pada halaman admin sebuah aplikasi web. Pengujian mencakup login admin, menambahkan kategori, mencari kategori, serta penghapusan kategori.

## Struktur Repository
```
TestNG/
│-- src/
│   ├── main/
│   │   └── java/
│   │       └── com/belajartestng/
│   │           ├── authentication/  # Kelas untuk autentikasi
│   │           ├── pages/           # Kelas untuk menangani halaman web
│   │           └── utils/           # Utility classes (jika ada)
│   └── test/
│       └── java/
│           └── com/belajartestng/
│               └── categorys/       # Kelas pengujian untuk kategori
│-- pom.xml                          # Konfigurasi Maven
│-- README.md                        # Dokumentasi proyek
```

## Instalasi & Konfigurasi

### Prasyarat
- **Java 17 atau lebih baru**
- **Maven**
- **Google Chrome & ChromeDriver**

### Langkah Instalasi
1. Clone repository:
   ```sh
   git clone https://github.com/JuaraCodingFerdi/Ujian-Minggu-ke-3
   cd Ujian-Minggu-ke-3
   ```
2. Install dependency dengan Maven:
   ```sh
   mvn clean install
   ```
3. Pastikan `chromedriver` sudah sesuai dengan versi Chrome Anda.

## Menjalankan Pengujian

### Menjalankan semua tes
```sh
mvn test
```

### Menjalankan tes tertentu
Gunakan `-Dtest` untuk menjalankan tes spesifik, misalnya:
```sh
mvn test -Dtest=CategorysTestAdmin
```

## Fitur Pengujian
- **Login Admin** sebelum mengakses halaman kategori
- **Tambah Kategori** dan verifikasi keberhasilannya
- **Pencarian Kategori** untuk memastikan kategori yang ditambahkan muncul
- **Penghapusan Kategori** (termasuk penghapusan semua kategori sekaligus)

## Teknologi yang Digunakan
- **Selenium WebDriver** (Automasi browser)
- **TestNG** (Framework pengujian)
- **Maven** (Manajemen dependensi)

## Catatan Tambahan
- Jika ingin mengubah URL aplikasi yang diuji, perbarui di dalam kelas `setUp()` pada `SignInTestAdmin.java`.
- Gunakan konfigurasi `testng.xml` jika ingin menjalankan tes dengan lebih terstruktur.


