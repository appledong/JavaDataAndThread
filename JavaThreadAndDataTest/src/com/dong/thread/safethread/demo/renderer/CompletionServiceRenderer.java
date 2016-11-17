package com.dong.thread.safethread.demo.renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.dong.thread.safethread.bean.ImageData;

/**
 * CompletionService实现渲染器
 * @author dong
 * 典型的生产者消费者模式，并发
 *
 */
public class CompletionServiceRenderer {
	
	private final ExecutorService executorService = Executors
			.newFixedThreadPool(10); // 10线程的线程池
	
	/**
	 * 通过future实现一个线程去下载图片，主线程渲染图片
	 * @param json
	 */
	public void renderPage(String json) {
		final List<ImageData> images = new ArrayList<>();
		String source = json.toString();//获取图片的信息
		ImageData imageinfo = scanImageData(source);
		images.add(imageinfo);
		CompletionService<ImageData> completionService = new ExecutorCompletionService<>(executorService);
		for (final ImageData imageData2 : images) {
			Callable<ImageData> callable = new Callable<ImageData>() {

				@Override
				public ImageData call() throws Exception {
					return download(imageData2)?imageData2:null;
				}

				private boolean download(ImageData imageData) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			completionService.submit(callable);//Future<ImageData> f = 
		}
		renderText();
		for (int i = 0,n=images.size(); i < n; i++) {
			try {
				Future<ImageData> f = completionService.take();
				ImageData imageData = f.get();
				renderImage(imageData);
			} catch (InterruptedException e) {
				//图片渲染失败
				e.printStackTrace();
			} catch (ExecutionException e) {
				//图片渲染失败
				e.printStackTrace();
			}
		}
	}

	private void renderImage(ImageData imageData) {

	}

	private ImageData scanImageData(String source) {
		return null;
	}

	private void renderText() {

	}

}
