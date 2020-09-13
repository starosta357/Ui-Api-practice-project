package api.keywords;

public class KeywordManager {

    private static KeywordManager instance = null;

    private final CustomerKeywords customerKeywords = new CustomerKeywords();

    private KeywordManager() {
    }

    public static KeywordManager getInstance(){
        if (instance == null)
            instance = new KeywordManager();

        return instance;
    }

    public CustomerKeywords customer(){
        return customerKeywords;
    }

}
