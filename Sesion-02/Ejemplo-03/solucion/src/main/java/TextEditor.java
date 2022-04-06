public class TextEditor {

  private Command saveCommand;

  public TextEditor() {
    saveCommand = new SaveCommand();
  }

  /*
    Guarda el archivo cuando el usuario
    presiona el botón de GUARDAR
  */
  public void onPressSaveButton() {
    System.out.println("[Save Button]");
    saveCommand.execute();
  }

  /*
    Guarda el archivo cuando el usuario
    presiona en el menú "GUARDAR ARCHIVO".
  */
  public void onMenuSaveOption() {
    System.out.println("[Menu]");
    saveCommand.execute();
  }

  /*
    Guardar el archivo cuando el usuario
    presiona la combinación en el teclado.
  */
  public void onShortcut() {
    System.out.println("[Shortcut]");
    saveCommand.execute();
  }
}
