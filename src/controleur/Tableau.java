package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel
{
	private Object donnees [] [];
	private String entetes [];
	
	public Tableau (Object donnees [][], String entetes[])
	{
		this.donnees=donnees;
		this.entetes = entetes;
	}


@Override 
public int getRowCount() {
	// TODO Auto-generated method stub
	return this.donnees.length;
}

@Override
public int getColumnCount() {
	// TODO Auto-generated method stub
	return this.entetes.length;
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
	// TODO Auto-generated method stub
	return this.donnees[rowIndex] [columnIndex];
}


@Override
public String getColumnName(int column) {

	return this.entetes[column];
}

public void insertTable (Object ligne [])
{
	//on définit une matrice
	Object matrice [] [] = new Object [this.donnees.length +1] [this.entetes.length];
	for (int i=0; i<this.donnees.length; i++)
	{
		matrice [i] = this.donnees [i];
	}
	matrice [this.donnees.length] = ligne;
	this.donnees = matrice;
	this.fireTableDataChanged();
}

	public void deleteTable (int rowIndex)
	{
		Object matrice [] [] = new Object [this.donnees.length -1] [this.entetes.length];
		int j = 0;
		for (int i = 0; i<this.donnees.length; i++)
		{
			if (i != rowIndex)//rowindex = num de la ligne que l'on veut supp
			{
				matrice [j] = this.donnees[i];
				j++;
			}
		}
		this.donnees = matrice;
		this.fireTableDataChanged();
	}
	public void updateTable (Object ligne [], int rowIndex)
	{
		Object matrice [] [] = new Object [this.donnees.length ] [this.entetes.length];
		for (int i = 0; i<this.donnees.length; i++)
		{
			if (i == rowIndex)//rowindex = num de la ligne que l'on veut supp
			{
				matrice [i] = ligne;
				
			}else 
			{
				matrice [i] = this.donnees[i];
			}
		}
		this.donnees = matrice;
		this.fireTableDataChanged();
	}


	public void setDonnees(Object[][] matrice) {
		this.donnees = matrice ; 
		this.fireTableDataChanged();
		
	}
}
