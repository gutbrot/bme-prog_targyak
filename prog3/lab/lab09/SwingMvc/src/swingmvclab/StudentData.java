package swingmvclab;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentData extends AbstractTableModel {

    // Ne modositsd!
    List<Student> students = new ArrayList<Student>();

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch(columnIndex) {
            case 0: return student.getName();
            case 1: return student.getNeptun();
            case 2: return student.hasSignature();
            default: return student.getGrade();
        }
    }

    @Override
    public String getColumnName(int col){
        String[] columnNames = { "Nev", "Neptun", "Alairas", "Jegy" };
        return columnNames[col];
    }

    public Class<?> getColumnClass(int c) {
        switch (c) {
            case 0:
            case 1:
                return String.class;
            case 2:
                return Boolean.class;
            case 3:
                return Integer.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col <= 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Student temp = students.get(row);
        switch (col){
            case 2:
                temp.setSignature((Boolean) value);
                break;
            case 3:
                temp.setGrade((Integer) value);
                break;
            default:
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addStudent(String name, String neptun) {
        Student temp = new Student(name,neptun,false,0);
        students.add(temp);
        fireTableRowsUpdated(0,this.getRowCount());
    }
}
