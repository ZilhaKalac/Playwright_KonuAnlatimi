import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Example {
    static void main() {

             // playwright başlatıldı
        try (Playwright playwright = Playwright.create()) {
            //Browser başlatılıyor
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(500)
            );

            // yeni tab oluşturmak, yeni sekme açılması için kullanılır. Zorunlu değildir
            BrowserContext browserContext = browser.newContext();
            // Page page = browser.newPage();   bu şekilde de kullanılabilir
            Page page = browserContext.newPage();

            //burada siteyi açtık
            page.navigate("https://saucedemo.com/");
            System.out.println(page.title());
            page.pause();   //inspectoru başlatmak için kullandık

            Locator username = page.getByPlaceholder("Username");
            username.fill("standard_user");

            Locator password = page.getByPlaceholder("Password");
            password.fill("secret_sauce");

            Locator loginBtn =page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
            loginBtn.click();


            //burada siteyi kapattık
            browser.close();


        }
    }
}
