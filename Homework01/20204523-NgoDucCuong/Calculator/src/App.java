public class App {
    public static void main(String[] args) throws Exception {
        CalModel calModel = new CalModel();
        CalView calView = new CalView();
        CalController controller = new CalController(calView, calModel);

        calView.setVisible(true);
    }
}
