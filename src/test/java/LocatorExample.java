import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorExample {
    static void main() {


        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(300)
            );


            Page page = browser.newPage();
            page.navigate("https://saucedemo.com/");

            /*  ID ile locator
                     page.locator("#user-name");   -> CSS ve id ile locator bulma
               (her zaman id olmayabilir)
             */

            /*  class isimleri css için kullanılıyor frontend devler
                o yüzden sürekli değişir. bizim için kullanımı avantaj sağlamaz

                     page.locator(".input_error form_input") -> class ile locator bulma
             */

            /*  Attribute ile locator bulma
                     page.locator("[data-test='login-button']")
                     page.locator("name='login-button'")
                     page.locator("id='login-button'")

               (her kullanımda sonuc aynı olur, hepsi attribute ile locator bulmaya örnektir)
             */

            /*  Text ile locator bulma
                     page.locator("text=Login")
                     page.getByText("Login")

                (eğer sayfada dil değişirse bu locator kullanılmaz hale gelir)
             */

            /*  Role ile locator bulma
                (bu yapıyı kullanmakta bir sorun yok)

                     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
             */

            /* Placeholder ile locator bulma

                     page.getByPlaceholder("Username")
                     page.getByPlaceholder("Password")
             */

            /*  Form yapılarında Label ile locator bulma
                     <label>Username</label>

                     page.getByLabel("Username")
             */

            /* Test id ile locator bulma

                     page.getByTestId("login-button")
             */

            /*  CSS (parent-child)

                     page.locator("form#login-form input #user-name")
             */

            /*   nth() kullanarak locator bulma

                     page.locator("input") -> tag ismiyle aratırsam sayfadaki tüm input alanlarının locatorı gelir
                     page.locator("input").nth(0)
                     page.locator().first()
                     page.locator().last()
             */

            /*  Filtreleme ile locator bulma
                (karmasık DOM yapısında bu kullanım büyük avantaj sağlar

                    page.locator("button").filter(
                    new Locator.FilterOptions().setHasNext("Login"))
             */

            /* XPath

                    page.locator("//input[@id='user-name'])

             */

            /*  Locator seçerken kullanılacak sıra

                    getByTestId -> getByRole -> CSS ->XPath
             */




        }
    }
}
