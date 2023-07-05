package com.techlabs.tictactoetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.techlabs.tictactoe.MarkType;
import com.techlabs.tictactoe.Player;

class TestPlayer {

	private Player player;

    @BeforeEach
    public void init() {
        player = new Player("Vismita", MarkType.O);
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("Vismita", player.getName());
    }

    @Test
    public void testGetMark() {
        Assertions.assertEquals(MarkType.O, player.getMark());
    }

}
