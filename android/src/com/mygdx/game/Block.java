package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
public class Block {
    int x;
    int y;
    int width;
    int height;

    public Block(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw (ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(x, y, width, height);
    }
}
