package com.raven.model;

import java.util.List;
import javax.swing.Icon;
import javax.swing.JPanel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model_Card {
    private Icon icon;
    private String title;
    private String values;
    private List<NgayChieu> nc;
    private String MaPhim;
}
