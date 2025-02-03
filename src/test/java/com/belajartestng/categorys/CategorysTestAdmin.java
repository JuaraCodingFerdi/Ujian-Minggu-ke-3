package com.belajartestng.categorys;

import com.belajartestng.authentication.SignInTestAdmin;
import com.belajartestng.pages.categorys.CategorysPageAdmin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategorysTestAdmin {
    private WebDriver driver;
    private SignInTestAdmin signInTestAdmin;
    private CategorysPageAdmin categorysPageAdmin;

    @BeforeMethod
    public void setUp() {
        // Inisialisasi login admin
        signInTestAdmin = new SignInTestAdmin();
        signInTestAdmin.setUp();  // Menjalankan setUp() dari SignInTestAdmin
        driver = signInTestAdmin.getDriver(); // Mengambil driver setelah setUp() dijalankan

        // Login sebelum masuk halaman kategori
        driver.get("http://localhost:8000/admin");
        signInTestAdmin.signIn("admin", "123");

        // Inisialisasi halaman kategori
        categorysPageAdmin = new CategorysPageAdmin(driver);
    }
    // Menambahkan 1 barang
    @Test
    public void addCategoryTest() {
        System.out.println("Memulai tes tambah kategori...");
        String categoryName = "Sabun Mandi";

        // Navigasi ke halaman kategori
        categorysPageAdmin.goToCategoryPage();

        // Tunggu selama 5 detik untuk memastikan halaman sepenuhnya dimuat
        try {
            Thread.sleep(2000);  // Tunggu 5 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verifikasi apakah sudah di halaman kategori
        Assert.assertTrue(categorysPageAdmin.isOnCategoryPage(), "Gagal masuk ke halaman kategori!");

        // Klik tombol "Add" kategori
        categorysPageAdmin.addCategorys();

        // Tambahkan delay untuk memastikan halaman tambah kategori terbuka
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Input kategori dan simpan
        categorysPageAdmin.createCategory(categoryName);

        // Kembali ke halaman kategori setelah save
        categorysPageAdmin.goToCategoryPage();

        // Pencarian kategori
        categorysPageAdmin.searchCategory(categoryName);

        // Verifikasi kategori ditemukan
        Assert.assertTrue(categorysPageAdmin.isCategoryFound(categoryName), "Kategori tidak ditemukan setelah ditambahkan!");

        System.out.println("Tes tambah dan pencarian kategori selesai.");


        System.out.println("Tes tambah kategori selesai.");
    }
    //Menambah banyak barang
//    @Test
//    public void addMultipleCategoriesAndVerify() {
//        // Daftar kategori yang akan ditambahkan
//        String[] categories = {
//                "Sabun Mandi", "Shampoo", "Pasta Gigi", "Sikat Gigi", "Sabun Cuci Tangan",
//                "Hand Sanitizer", "Sabun Cuci Baju", "Pembersih Lantai", "Pewangi Ruangan", "Lotion"
//        };
//
//        System.out.println("Memulai tes untuk menambahkan dan mencari 10 kategori...");
//
//        // Navigasi ke halaman kategori
//        categorysPageAdmin.goToCategoryPage();
//        Assert.assertTrue(categorysPageAdmin.isOnCategoryPage(), "Gagal masuk ke halaman kategori!");
//
//        // Loop untuk menambahkan banyak kategori
//        for (String category : categories) {
//            System.out.println("Menambahkan kategori: " + category);
//            categorysPageAdmin.addCategorys();
//
//            // Tunggu sejenak agar halaman form tambah kategori terbuka
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            categorysPageAdmin.createCategory(category);
//
//            // Kembali ke halaman kategori setelah save
//            categorysPageAdmin.goToCategoryPage();
//        }
//
//        System.out.println("Semua kategori telah ditambahkan. Memulai pencarian...");
//
//        // Loop untuk mencari dan memverifikasi kategori yang ditambahkan
//        for (String category : categories) {
//            System.out.println("Mencari kategori: " + category);
//            categorysPageAdmin.searchCategory(category);
//
//            // Verifikasi kategori ditemukan
//            Assert.assertTrue(categorysPageAdmin.isCategoryFound(category), "Kategori tidak ditemukan setelah ditambahkan!");
//        }
//
//        System.out.println("Tes selesai. Semua kategori berhasil ditambahkan dan diverifikasi.");
//    }
    //Hapus 1 barang
//    @Test
//    public void testDeleteCategory() {
//        CategorysPageAdmin categorysPageAdmin = new CategorysPageAdmin(driver);
//
//        // Arahkan ke halaman kategori
//        categorysPageAdmin.goToCategoryPage();
//
//        // Hapus kategori
//        categorysPageAdmin.deleteCategoryByName("Sabun Cuci Baju");
//
//        // Verifikasi bahwa kategori berhasil dihapus dengan memastikan kategori tidak ditemukan
//        boolean isCategoryFound = categorysPageAdmin.isCategoryFound("Lotion");
//        Assert.assertFalse(isCategoryFound, "Kategori tidak berhasil dihapus, masih ada kategori yang ditemukan!");
//    }
    //Hapus Semua Barang
//    @Test
//    public void testDeleteAllCategory() {
//        CategorysPageAdmin categorysPageAdmin = new CategorysPageAdmin(driver);
//
//        // Arahkan ke halaman kategori
//        categorysPageAdmin.goToCategoryPage();
//
//        // Hapus semua kategori
//        categorysPageAdmin.deleteAllCategories();
//
//        // Verifikasi bahwa kategori berhasil dihapus dan jumlah kategori menjadi 0
//        Assert.assertFalse(categorysPageAdmin.isCategoryDeleted(), "Hapus semua");
//    }





    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
