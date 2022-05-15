package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    //region LogicFieldsDefinitions
    private boolean isFirstPart = true;
    private char operator = ' ';
    private int operatorIndex = 0;
    private String firstPart = "";
    private String secondPart = "";
    //endregion
    //region UIFieldsDefinitions
    @FXML
    private Button clearAll_btn;

    @FXML
    private Button clear_btn;

    @FXML
    private Button div_btn;

    @FXML
    private Button eight_btn;

    @FXML
    private Button enter_btn;

    @FXML
    private Button five_btn;

    @FXML
    private Button four_btn;

    @FXML
    private Button minus_btn;

    @FXML
    private Button mult_btn;

    @FXML
    private Button nine_btn;

    @FXML
    private Button one_btn;

    @FXML
    private Button plus_btn;

    @FXML
    private Button seven_btn;

    @FXML
    private Button six_btn;

    @FXML
    private Label textField;

    @FXML
    private Button three_btn;

    @FXML
    private Button two_btn;

    @FXML
    private Button zero_btn;

    //endregion
    private void addNumber(int number){
        String textFieldValue = this.textField.getText();
        if (number == 0){
            if(textFieldValue.charAt(0) == '0' && textFieldValue.length() == 1){
                return;
            }
        }
        else if(textFieldValue.length() == 1 && textFieldValue.charAt(0) == '0'){
            this.textField.setText(String.valueOf(number));
            return;
        }
        this.textField.setText(this.textField.getText() + number);
    }
    private void clearSymbol(){
        if(textField.getText().length() == 1){
            textField.setText("0");
            return;
        }
        textField.setText(textField.getText().substring(0, textField.getText().length()-1));
    }
    @FXML
    void initialize(){
        one_btn.setOnAction(event -> {
            StringBuilder value = new StringBuilder();
            value.append(event.getTarget().toString());
            value.reverse();
            addNumber(Character.getNumericValue(value.charAt(1)));
        });
        two_btn.setOnAction(event -> {
            StringBuilder value = new StringBuilder();
            value.append(event.getTarget().toString());
            value.reverse();
            addNumber(Character.getNumericValue(value.charAt(1)));
        });
        three_btn.setOnAction(event -> {
            StringBuilder value = new StringBuilder();
            value.append(event.getTarget().toString());
            value.reverse();
            addNumber(Character.getNumericValue(value.charAt(1)));
        });
        four_btn.setOnAction(event -> {
            StringBuilder value = new StringBuilder();
            value.append(event.getTarget().toString());
            value.reverse();
            addNumber(Character.getNumericValue(value.charAt(1)));
        });
        five_btn.setOnAction(event -> {
            StringBuilder value = new StringBuilder();
            value.append(event.getTarget().toString());
            value.reverse();
            addNumber(Character.getNumericValue(value.charAt(1)));
        });
        six_btn.setOnAction(event -> {
            StringBuilder value = new StringBuilder();
            value.append(event.getTarget().toString());
            value.reverse();
            addNumber(Character.getNumericValue(value.charAt(1)));
        });
        seven_btn.setOnAction(event -> {
            StringBuilder value = new StringBuilder();
            value.append(event.getTarget().toString());
            value.reverse();
            addNumber(Character.getNumericValue(value.charAt(1)));
        });
        eight_btn.setOnAction(event -> {
            StringBuilder value = new StringBuilder();
            value.append(event.getTarget().toString());
            value.reverse();
            addNumber(Character.getNumericValue(value.charAt(1)));
        });
        nine_btn.setOnAction(event -> {
            StringBuilder value = new StringBuilder();
            value.append(event.getTarget().toString());
            value.reverse();
            addNumber(Character.getNumericValue(value.charAt(1)));
        });
        zero_btn.setOnAction(event -> {
            StringBuilder value = new StringBuilder();
            value.append(event.getTarget().toString());
            value.reverse();
            addNumber(Character.getNumericValue(value.charAt(1)));
        });
        mult_btn.setOnAction(event -> {
            if(!isFirstPart){
                return;
            }
            operator = '*';
            textField.setText(textField.getText()+'*');
            operatorIndex = textField.getText().length()-1;
            isFirstPart = false;
        });
        div_btn.setOnAction(event -> {
            if(!isFirstPart){
                return;
            }
            operator = '/';
            textField.setText(textField.getText()+'/');
            operatorIndex = textField.getText().length()-1;
            isFirstPart = false;
        });
        minus_btn.setOnAction(event -> {
            if(!isFirstPart){
                return;
            }
            operator = '-';
            textField.setText(textField.getText()+'-');
            operatorIndex = textField.getText().length()-1;
            isFirstPart = false;
        });
        plus_btn.setOnAction(event -> {
            if(!isFirstPart){
                return;
            }
            operator = '+';
            textField.setText(textField.getText()+'+');
            operatorIndex = textField.getText().length()-1;
            isFirstPart = false;
        });
        clearAll_btn.setOnAction(event -> {
            isFirstPart = true;
            textField.setText("0");
        });
        clear_btn.setOnAction(event -> {
            clearSymbol();
        });

        enter_btn.setOnAction(event -> {
            if(isFirstPart){
                return;
            }
            firstPart = textField.getText().substring(0, operatorIndex);
            secondPart = textField.getText().substring(operatorIndex+1, textField.getText().length());
            switch (operator){
                case '+':
                    textField.setText(String.valueOf(Double.parseDouble(firstPart)+Double.parseDouble(secondPart)));
                    break;
                case '-':
                    textField.setText(String.valueOf(Double.parseDouble(firstPart)-Double.parseDouble(secondPart)));
                    break;
                case '*':
                    textField.setText(String.valueOf(Double.parseDouble(firstPart)*Double.parseDouble(secondPart)));
                    break;
                case '/':
                    textField.setText(String.valueOf(Double.parseDouble(firstPart)/Double.parseDouble(secondPart)));
                    break;
                default:
                    break;
            }
            isFirstPart = true;
        });
    }
}
