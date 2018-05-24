public class PageFactoryConfiguration {
    private IElementsBuilder elementsBuilder;

    public IElementsBuilder getElementsBuilder() {
        return this.elementsBuilder;
    }

    public void setElementsBuilder(ElementsBuilder elementsBuilder) {
        this.elementsBuilder = elementsBuilder;
    }
}

class PageFactoryConfigurationExtensionMethods {
    public static PageFactoryConfiguration configureAppiumFrameworkElementsBuilder(PageFactoryConfiguration configuration) {
        ElementsBuilder elementsBuilder = new ElementsBuilder();
        elementsBuilder.registerAppiumFrameworkTypes();
        configuration.setElementsBuilder(elementsBuilder);
        return configuration;
    }
}