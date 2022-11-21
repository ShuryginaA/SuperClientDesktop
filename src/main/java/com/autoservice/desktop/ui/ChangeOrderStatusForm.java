package com.autoservice.desktop.ui;

import com.autoservice.desktop.service.RequestMaker;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

@Getter
public class ChangeOrderStatusForm {
    private JPanel changeOrderStatus;
    private JTextField id;
    private JComboBox status;
    private JButton okButton;



    public ChangeOrderStatusForm() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tmpStatus=status.getSelectedItem().toString();
                if(tmpStatus.equals("Взят в работу")){
                    tmpStatus="IN_PROGRESS";
                }
                else if(tmpStatus.equals("Готов")){
                    tmpStatus="READY";
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Вы не выбрали статус." +
                                    "Попробуйте снова.",
                            "Ошибка",
                            JOptionPane.WARNING_MESSAGE);
                }
                RequestMaker.sendRequestToChangeStatus(
                        id.getText(), tmpStatus
                );
            }
        });
    }
}
