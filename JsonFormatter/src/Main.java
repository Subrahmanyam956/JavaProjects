public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        InputJsonReader inputJsonReader = new InputJsonReader();
//        String inputJson = inputJsonReader.readJsonFromConsole();

        String inputJson = "{\"name\":\"Jane Doe\",\"favorite-game\":\"Stardew Valley\"," +
                "\"subscriber\":false}";
        JsonFormatter jsonFormatter = new JsonFormatter();
        String outputJson = jsonFormatter.formatJson(inputJson);
        System.out.println("Output Json : ");
        System.out.println(outputJson);
    }
}