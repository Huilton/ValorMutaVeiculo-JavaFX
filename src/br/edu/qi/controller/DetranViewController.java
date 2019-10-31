package br.edu.qi.controller;

import br.edu.qi.MainApp;
import br.edu.qi.model.DadosVeiculo;
import br.edu.qi.model.DadosVeiculoVO;
import br.edu.qi.model.DadosVeiculoDAO;
import br.edu.qi.utl.HelperNumbers;
import br.edu.qi.view.DetranModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DetranViewController implements Initializable {

    private Stage dialogStage;
    private DadosVeiculo loc;
    private ObservableList<DetranModel> dados;

    @FXML
    private Label lblProprietario;
    private TextField txtProprietario;
    private ComboBox cbcMarca;
    @FXML
    private Label lblModelo;
    @FXML
    private Label lblAno;
    private TextField txtModelo;
    private TextField txtDescricao;
    private TextField txtAno;
    @FXML
    private Button btSalvar;
    @FXML
    private TableView<DetranModel> tvLocacao;
    @FXML
    private Button btLimpar;
    @FXML
    private Button btRemover;

    private TextField txtValorVeiculo;
    @FXML
    private Label lblValorVeiculo;
    private TextField txtkm;
    @FXML
    private Label lblkm;
    @FXML
    private Button btConsultar;
    @FXML
    private Label lblAno1;
    @FXML
    private TableColumn colunmPlaca;
    @FXML
    private TableColumn colunmData;
    @FXML
    private TableColumn colunmHorario;
    @FXML
    private TableColumn colunmLocal;
    @FXML
    private TextField txtPlaca;
    @FXML
    private TextField txtData;
    @FXML
    private TextField txtVelocidadeVeiculo;
    @FXML
    private Label lblProprietario1;
    @FXML
    private TextField txtHorario;
    @FXML
    private TextField txtValoAPagar;
    @FXML
    private TextField txtLocal;
    @FXML
    private Label lblModelo1;
    @FXML
    private TextField txtVelocidadePermitaKm;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colunmPlaca.setCellValueFactory(new PropertyValueFactory<DetranModel, String>("placa"));
        colunmData.setCellValueFactory(new PropertyValueFactory<DetranModel, String>("data"));
        colunmHorario.setCellValueFactory(new PropertyValueFactory<DetranModel, Integer>("hora"));
        colunmLocal.setCellValueFactory(new PropertyValueFactory<DetranModel, String>("local"));

        dados = FXCollections.observableArrayList();
        tvLocacao.setItems(dados);
        loc = DadosVeiculo.getInstance();

    }

    public void setDialogStage(Stage dialog) {
        this.dialogStage = dialog;
    }

    private void validation() throws Exception {

        if (txtPlaca.getText().length() == 0) {
            throw new Exception("Informe uma placa para o veículo!");
        }
        if (txtData.getText().length() == 0) {
            throw new Exception("Informe uma data para o veículo!");
        }
        if (txtHorario.getText().length() == 0) {
            throw new Exception("Informe uma horário para o veículo!");
        }
        if (txtLocal.getText().length() == 0) {
            throw new Exception("Informe um local valido para o veículo!");
        }

        if (!HelperNumbers.isNumeric(txtVelocidadePermitaKm.getText()) || Double.parseDouble(txtVelocidadePermitaKm.getText()) <= 0) {
            throw new Exception("Informe um valor válido para a velocidade permitida em km!");
        }
        if (!HelperNumbers.isNumeric(txtVelocidadeVeiculo.getText()) || Double.parseDouble(txtVelocidadeVeiculo.getText()) <= 0) {
            throw new Exception("Informe um valor válido para a velocidade permitida em km!");
        }

    }

    public void msgDialog(String msg, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Detran");
        alert.setContentText(msg);
        alert.show();
    }

    @FXML
    private void handSalvar(ActionEvent event) {
        try {
            validation();

            DetranModel dadosDetran = new DetranModel();
            dadosDetran.setPlaca(txtPlaca.getText());
            dadosDetran.setData(txtData.getText());
            dadosDetran.setHora(txtHorario.getText());
            dadosDetran.setLocal(txtLocal.getText());
            dadosDetran.setVelocidadePermitidaKm(Double.parseDouble(txtVelocidadePermitaKm.getText()));
            dadosDetran.setVelocidadeDoVeiculo(Double.parseDouble(txtVelocidadeVeiculo.getText()));

            loc.save(new DadosVeiculoVO(
                    dadosDetran.getPlaca(),
                    dadosDetran.getData(),
                    dadosDetran.getHora(),
                    dadosDetran.getLocal(),
                    dadosDetran.getVelocidadeMaximaPermitidaKm(),
                    dadosDetran.getVelocidadeDoVeiculo(),
                    dadosDetran.getValorAPagar()));
            dados.add(dadosDetran);
            double velocidadeMax = Double.parseDouble(txtVelocidadePermitaKm.getText());
            double velocidadeCarro = Double.parseDouble(txtVelocidadeVeiculo.getText());
            DadosVeiculoDAO d  = new DadosVeiculoDAO();
            double resultado = d.calcularMulta(velocidadeMax, velocidadeCarro);

            msgDialog("Cadastrado Com Sucesso.\nO valor da Multa é: "+resultado, Alert.AlertType.INFORMATION);
            handLimpar(event);
        } catch (Exception ex) {
            msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
            System.out.println("erro: " + ex);
        }
    }

    private void limpar() {
        txtPlaca.setText("");
        txtData.setText("");
        txtHorario.setText("");
        txtLocal.setText("");
        txtVelocidadePermitaKm.setText("");
        txtVelocidadeVeiculo.setText("");

    }

    @FXML
    private void handLimpar(ActionEvent event) {
        limpar();
    }

    @FXML
    private void handRemover(ActionEvent event) throws Exception {
        DetranModel locM = (DetranModel) tvLocacao.getSelectionModel().getSelectedItem();
        int index = tvLocacao.getSelectionModel().getSelectedIndex();
        dados.remove(locM);
        loc.remove(index);
        msgDialog("Veiculo excluido com sucesso!", Alert.AlertType.INFORMATION);
    }

}
