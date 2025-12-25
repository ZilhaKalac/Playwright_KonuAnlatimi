package pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    // Locators
    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginBtn = "#login-button";
    private final String errorMessage = "[data-test='error']";

    public LoginPage fillUsername(String username) {
        type(usernameInput, username);                      // Usename alanını doldurur, sayfa değişmediği için LoginPage döndürür
        return this;
    }

    public LoginPage fillPassword(String password) {
        type(passwordInput, password);
        return this;                                       // Password alanını doldurur, sayfa değişmediği için LoginPage döndürür
    }

    public ProductsPage clickLoginBtnSuccess() {
        click(loginBtn);                                   // Login işlemi başarılı olduğunda kullanıcı ProductsPage'e yönlendirilir.
        return new ProductsPage(page);                     // POM prensibi gereği, sayfa değiştiği için yeni sayfayı temsil eden Page Object döndürülür.
    }


    public LoginPage clickLoginBtnFail() {
        // Login olup da page deiğşmediği için LoginPage'de kaldığını belirtiyoruz
        click(loginBtn);                                    // Login işlemi başarısız olduğunda aynı sayfada (loginPage) kalınır, nu yüzden LoginPage döndürülür
        return this;
    }

    public ProductsPage loginAs(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLoginBtnSuccess();
        return new ProductsPage(page);                    // Başarılı bir şekilde login olduktan sonra açılan saya Product Page oldugu için metodun dönüş değeri void olamaz

    }

    public String getErrorMessage () {
        return getText(errorMessage);
    }

    public boolean isErrorMessageVisible() {
        return isVisible(errorMessage);
    }


    // Neden return ifadesini sadece clickLogin'de kullandık?
    // diğer methodlarda hatalı yada doğru giriş olup olmamasına bakmadan sayfada herhangi bir değişiklik olup
    // başka bir sayfaya navigate olmuyor
    // Ama login butonuna bastığımda eğer işlem basarılı olursa sayfa (Page) değişiyor
    // POM yapısı gereği bunu belirmtem gerek ki devam eden testlerde sayfa (Page) ile alakalı sorun yaşamayalım


}
