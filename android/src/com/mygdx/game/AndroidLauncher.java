package com.mygdx.game;

import android.os.Bundle;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;
import java.util.Random;

public class AndroidLauncher extends AndroidApplication implements ApplicationListener {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration configuration = new AndroidApplicationConfiguration();
		initialize(this, configuration);

	}

	@Override
	protected void onResume() {
		super.onResume();
	}


	ShapeRenderer shapeRenderer;
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;
	Random r = new Random();
	int rightSide = 1000;
	int leftSide = 400;
	int randomSideAtStart = Math.random()<0.5?-10:10;

	@Override
	public void create() {
		shapeRenderer = new ShapeRenderer();
		shape = new ShapeRenderer();
		ball = new Ball(500, 300, 40, 0, 0);
		paddle = new Paddle(1000, 20, 200, 5);

	}

	@Override
	public void resize(int width, int height) {

	}


	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		ball.update();
		ball.draw(shapeRenderer);
		ball.checkCollision(paddle);

		shape.begin(ShapeRenderer.ShapeType.Filled);
		paddle.draw(shape);


		shapeRenderer.end();
		shape.end();

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {


	}
}