package com.belajartestng.pages.categorys;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategorysPageAdmin {
    private WebDriver driver;
    private WebDriverWait wait;

    // XPath untuk navigasi dan verifikasi halaman kategori
    private By categoryMenu = By.xpath("//*[@id='products-category']/a");
    private By pageHeader = By.xpath("//*[@id='content']/h1");
    private By add = By.xpath("//*[@id=\"nav-sidebar\"]/div[2]/table/tbody/tr[1]/td/a");
    private By nameInput = By.xpath("//*[@id='id_name']"); // Input kategori
    private By saveButton = By.name("_save"); // Tombol simpan kategori

    // Locator untuk pencarian
    private By searchBar = By.id("searchbar"); // Input pencarian kategori
    private By searchButton = By.xpath("//*[@id='changelist-search']/div/input[2]"); // Tombol cari
    private By searchResult = By.xpath("//*[@id='result_list']/tbody/tr/th/a"); // Hasil pertama di list

    // Locator untuk penghapusan kategori
    private By deleteButton = By.className("deletelink"); // Tombol hapus
    private By confirmDeleteButton = By.xpath("//*[@id='content']/form/div/input[2]"); // Konfirmasi hapus
    private By confirmDeleteAllButton = By.xpath("//input[@value='Yes, I’m sure");

    private By categoryCountText = By.xpath("//*[@id='changelist-form']/p");

    public CategorysPageAdmin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigasi ke halaman kategori
    public void goToCategoryPage() {
        WebElement categoryLink = wait.until(ExpectedConditions.elementToBeClickable(categoryMenu));
        categoryLink.click();
    }

    // Verifikasi apakah sudah berada di halaman kategori
    public boolean isOnCategoryPage() {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        return header.getText().equals("Select category to change");
    }

    // Klik tombol "Add" kategori
    public void addCategorys() {
        WebElement addCategory = wait.until(ExpectedConditions.elementToBeClickable(add));
        try {
            addCategory.click(); // Klik biasa
        } catch (Exception e) {
            System.out.println("Klik biasa gagal, mencoba dengan JavaScript Executor...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addCategory);
        }
    }

    // Mengisi kategori dan menyimpan
    public void createCategory(String categoryName) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        nameField.clear();
        nameField.sendKeys(categoryName);

        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveBtn.click();
    }

    // Mencari kategori di search bar
    public void searchCategory(String categoryName) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        searchInput.clear();
        searchInput.sendKeys(categoryName);

        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();
    }

    // Memverifikasi apakah kategori yang dicari ada di hasil pencarian
    public boolean isCategoryFound(String expectedCategory) {
        try {
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
            String actualCategory = result.getText();
            System.out.println("Kategori ditemukan: " + actualCategory);
            return actualCategory.equals(expectedCategory);
        } catch (Exception e) {
            System.out.println("Kategori tidak ditemukan.");
            return false;
        }
    }


    // Menghapus kategori berdasarkan nama
    public void deleteCategoryByName(String categoryName) {
        // Cari kategori terlebih dahulu
        searchCategory(categoryName);

        // Klik hasil pencarian pertama yang sesuai dengan nama kategori
        WebElement result = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(categoryName)));
        result.click();

        // Klik tombol hapus
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteBtn.click();

        // Konfirmasi penghapusan
        WebElement confirmDelete = wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton));
        confirmDelete.click();
    }
    public void deleteAllCategories() {
        // Pilih opsi 'delete_selected' dari dropdown
        WebElement deleteSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='changelist-form']/div[1]/label/select")));
        deleteSelect.click();
        WebElement deleteOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='changelist-form']/div[1]/label/select/option[@value='delete_selected']")));
        deleteOption.click();

        // Pilih checkbox untuk memilih semua kategori
        WebElement checkAll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='action-toggle']")));
        checkAll.click();

        // Klik tombol 'Go' untuk menghapus kategori
        WebElement goButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='changelist-form']/div[1]/button")));
        goButton.click();

        // Konfirmasi penghapusan kategori
        WebElement confirmDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Yes, I’m sure']")));

        // Klik tombol konfirmasi
        confirmDeleteButton.click();
    }

    public boolean isCategoryDeleted() {
        WebElement categoryCount = wait.until(ExpectedConditions.visibilityOfElementLocated(categoryCountText));
        String text = categoryCount.getText();

        // Cek apakah teksnya mengandung "0 categories"
        return text.contains("0 categories");
    }
}
