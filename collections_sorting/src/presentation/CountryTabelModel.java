package presentation;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import htlklu.sorting.Country;

public class CountryTabelModel extends AbstractTableModel {
	
	private static final String[] COLUMN_NAMES = {"Name", "Capital", "Population", "Area"};
	
	private ArrayList<Country> countries;
	
	public CountryTabelModel(ArrayList<Country> countries) {
		this.countries = countries;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return countries.get(rowIndex).toArray()[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		return countries.size();
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}
	
	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}
	
}
