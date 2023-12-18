package com.example.examendiw;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.time.LocalDate;

public class HelloController {

    @FXML
    private TextField txtMatricula;

    @FXML
    private ComboBox<String> idModelo;

    @FXML
    private ComboBox<String> idCliente;

    @FXML
    private ToggleGroup tarifa;

    @FXML
    private DatePicker idEntrada;

    @FXML
    private DatePicker idSalida;

    @FXML
    private TableView<Registro> tabla;

    @FXML
    private Label info;

    @FXML
    private RadioButton standard;

    @FXML
    private RadioButton oferta;

    @FXML
    private RadioButton largaduracion;

    @FXML
    private Button btnAñadir;

    @FXML
    private Button btnSalir;

    // Método de inicialización del controlador (puedes agregar más lógica si es necesario)

    @FXML
    private void initialize() {
        // Inicializar ComboBox de Modelo con valores ficticios
        idModelo.getItems().addAll("Modelo1", "Modelo2", "Modelo3");

        // Inicializar ComboBox de Cliente con valores ficticios
        idCliente.getItems().addAll("Cliente1", "Cliente2", "Cliente3");

        // Configurar el formato de fecha en los DatePickers
        configureDatePickers();

        // Configurar las columnas de la tabla solo si aún no se han configurado
        if (tabla.getColumns().isEmpty()) {
            configureTableColumns();
        }
    }

    // Configurar DatePickers para mostrar el formato de fecha adecuado
    private void configureDatePickers() {
        idEntrada.setConverter(new StringConverter<>() {
            @Override
            public String toString(LocalDate date) {
                return (date != null) ? date.toString() : "";
            }

            @Override
            public LocalDate fromString(String string) {
                return (string != null && !string.isEmpty()) ? LocalDate.parse(string) : null;
            }
        });

        idSalida.setConverter(new StringConverter<>() {
            @Override
            public String toString(LocalDate date) {
                return (date != null) ? date.toString() : "";
            }

            @Override
            public LocalDate fromString(String string) {
                return (string != null && !string.isEmpty()) ? LocalDate.parse(string) : null;
            }
        });
    }



    // Configurar las columnas de la tabla
    private void configureTableColumns() {
        TableColumn<Registro, String> cMatricula = new TableColumn<>("Matricula");
        cMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        TableColumn<Registro, String> cModelo = new TableColumn<>("Modelo");
        cModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        TableColumn<Registro, LocalDate> cEntrada = new TableColumn<>("Fecha de entrada");
        cEntrada.setCellValueFactory(new PropertyValueFactory<>("fechaEntrada"));

        TableColumn<Registro, LocalDate> cSalida = new TableColumn<>("Fecha de salida");
        cSalida.setCellValueFactory(new PropertyValueFactory<>("fechaSalida"));

        TableColumn<Registro, String> cCliente = new TableColumn<>("Cliente");
        cCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));

        TableColumn<Registro, String> cTarifa = new TableColumn<>("Tarifa");
        cTarifa.setCellValueFactory(new PropertyValueFactory<>("tarifa"));

        TableColumn<Registro, Double> cCoste = new TableColumn<>("Coste");
        cCoste.setCellValueFactory(new PropertyValueFactory<>("coste"));

        tabla.getColumns().addAll(cMatricula, cModelo, cEntrada, cSalida, cCliente, cTarifa, cCoste);
    }

    // Método que se ejecuta al hacer clic en el botón "Añadir a la tabla"
    @FXML
    private void handleAñadirButton() {
        if (validateFields()) {
            // Calcular el coste
            double coste = calcularCoste();

            // Crear un nuevo registro
            Registro nuevoRegistro = new Registro(
                    txtMatricula.getText(),
                    idModelo.getValue(),
                    idEntrada.getValue(),
                    idSalida.getValue(),
                    idCliente.getValue(),
                    getSelectedRadioButtonText(),
                    coste
            );

            // Añadir el registro a la tabla
            tabla.getItems().add(nuevoRegistro);

            // Limpiar los campos
            limpiarCampos();

            // Imprimir mensajes de depuración
            System.out.println("Registro añadido a la tabla: " + nuevoRegistro);
        }
    }



    // Método que se ejecuta al hacer clic en el botón "Salir"
    @FXML
    private void handleSalirButton() {
        // Cerrar la aplicación
        System.exit(0);
    }

    // Método que se ejecuta al hacer clic en el enlace inferior con el nombre del alumno
    @FXML
    private void handleEnlaceAlumno(MouseEvent event) {
        // Mostrar un Alert con el nombre del alumno y el ciclo
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información del Alumno");
        alert.setHeaderText(null);
        alert.setContentText("Nombre del Alumno: Fernando Perez de Ayala\nCiclo: [2 DAM]");
        alert.showAndWait();
    }

    // Método para validar que todos los campos estén completos
    private boolean validateFields() {
        if (txtMatricula.getText().isEmpty() || idModelo.getValue() == null || idCliente.getValue() == null ||
                idEntrada.getValue() == null || idSalida.getValue() == null || getSelectedRadioButtonText().isEmpty()) {
            // Mostrar un Alert indicando que faltan campos
            mostrarAlerta("Faltan campos", "Todos los campos son obligatorios.");
            return false;
        }
        return true;
    }

    // Método para calcular el coste
    private double calcularCoste() {
        // Lógica para calcular el coste según la tarifa seleccionada y las fechas de entrada y salida
        // (Reemplazar con tu lógica específica)
        return 0.0;
    }

    // Método para obtener el texto del RadioButton seleccionado
    private String getSelectedRadioButtonText() {
        RadioButton selectedRadioButton = (RadioButton) tarifa.getSelectedToggle();
        return (selectedRadioButton != null) ? selectedRadioButton.getText() : "";
    }

    // Método para limpiar los campos después de añadir a la tabla
    private void limpiarCampos() {
        txtMatricula.clear();
        idModelo.setValue(null);
        idCliente.setValue(null);
        idEntrada.setValue(null);
        idSalida.setValue(null);
        tarifa.selectToggle(null);
    }

    // Método para mostrar un Alert
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
