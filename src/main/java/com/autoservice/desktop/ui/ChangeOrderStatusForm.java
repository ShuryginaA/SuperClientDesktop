package com.autoservice.desktop.ui;

import com.autoservice.desktop.service.FormCreator;
import com.autoservice.desktop.service.UtilClass;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class ChangeOrderStatusForm {
    private JPanel changeOrderStatusForm;
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
                if(UtilClass.sendRequestToChangeStatus(
                        id.getText(), tmpStatus
                ).equals("Success")){
                    JOptionPane.showMessageDialog(null,
                            "Статус обновлен",
                            "Успех",
                            JOptionPane.INFORMATION_MESSAGE);
                    FormCreator.statusForm.dispose();
                }
            }
        });
    }
}
