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


	ShapeRenderer shapeRendererBall;
	ShapeRenderer shapeRendererPaddle;
	ShapeRenderer shapeRendererBlock;

	Ball ball;
	Paddle paddle;
	Block block;

	int rightSide = 1000;
	int leftSide = 400;
	//int randomSideAtStart = Math.random()<0.5?-10:10;

	ArrayList<Block> blocksList = new ArrayList<>();
	int blockWidth = 100;
	int blockHeight = 20;

	@Override
	public void create() {
		shapeRendererBall = new ShapeRenderer();
		shapeRendererPaddle = new ShapeRenderer();
		shapeRendererBlock = new ShapeRenderer();

		ball = new Ball((rightSide - leftSide) + leftSide, 1000, 40, 10, -20);
		paddle = new Paddle(1000, 10, 200, 9);



		for (int y = (int) (Gdx.graphics.getHeight()/1.5); y < Gdx.graphics.getHeight(); y += blockHeight + 10) {

			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
				blocksList.add(new Block(x, y, blockWidth, blockHeight));
			}
		}
	}

	@Override
	public void resize(int width, int height) {

	}


	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRendererBall.begin(ShapeRenderer.ShapeType.Filled);
		ball.update();
		ball.draw(shapeRendererBall);
		ball.checkCollision(paddle);

		shapeRendererPaddle.begin(ShapeRenderer.ShapeType.Filled);
		paddle.draw(shapeRendererPaddle);


		shapeRendererBlock.begin(ShapeRenderer.ShapeType.Filled);
		for (Block block : blocksList) {
			block.draw(shapeRendererBlock);

		}

		shapeRendererBall.end();
		shapeRendererPaddle.end();
		shapeRendererBlock.end();

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