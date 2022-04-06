public class Application {

  public static void main(String[] args) {
    TextEditor editor = new TextEditor();

    // El usuario presiona el botón de guardar
    editor.onPressSaveButton();

    // El usuario presiona la opción de guardar en el menú
    editor.onMenuSaveOption();

    // El usuario presiona la combinación en el teclado
    editor.onShortcut();
  }
}
