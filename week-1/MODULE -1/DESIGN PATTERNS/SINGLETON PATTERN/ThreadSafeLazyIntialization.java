class ThreadSafeLazyIntialization {
    public static void main(String[] args) {
        
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();
        
        if(config1 == config2){
            System.out.println("Yeah both are refering to same object");
        }
    }
}

class AppConfig{
    private AppConfig(){
        
    }
    private static volatile AppConfig config = null;

    
    static AppConfig getInstance(){
        if(config == null){
            
            synchronized(AppConfig.class){
                if(config == null) config = new AppConfig();
            }
        }
        return config;
    }
}
