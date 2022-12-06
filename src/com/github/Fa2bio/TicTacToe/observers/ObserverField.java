package com.github.Fa2bio.TicTacToe.observers;

import com.github.Fa2bio.TicTacToe.model.Field;

@FunctionalInterface
public interface ObserverField {
	public void eventHappened(Field field, EventField event);
}
