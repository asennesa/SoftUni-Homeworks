package sayHelloExtend;

public class Bulgarian extends BasePerson {
    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
