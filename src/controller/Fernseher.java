package controller;

import java.awt.EventQueue;

import model.EinstellungenModel;

import view.HauptfensterView;

public class Fernseher {
	private static HauptfensterController hauptfenster;

	public static void main(String[] args) {
		try {
			hauptfenster = new HauptfensterController();
			hauptfenster.showView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
