package by.util.pages;

public enum Page {
    REGISTER_PAGE ("/WEB-INF/views/register.jsp"),
    WELCOME_PAGE ("/WEB-INF/views/welcome.jsp"),
    LOGIN_PAGE("/WEB-INF/views/login.jsp"),
    ERROR_PAGE ("/WEB-INF/views/errorPage.jsp");


    private final String value;

    Page(String value) {
        this.value = value;
    }

    public String getPage() {
        return value;
    }
}
