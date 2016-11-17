package com.dong.thread.safethread.demo.renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.dong.thread.safethread.bean.ImageData;

/**
 * Future实现的并发下载图片
 * 
 * @author dong
 *
 */
public class FutureRenderer {

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
		Callable<List<ImageData>> callable = new Callable<List<ImageData>>() {

			@Override
			public List<ImageData> call() throws Exception {
				ArrayList<ImageData> images2 = new ArrayList<>();
				for (ImageData imageData : images) {
					boolean isload = download(imageData);
					if(isload){
						images2.add(imageData);
					}
				}
				return images2;
			}

			private boolean download(ImageData imageData) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		Future<List<ImageData>> f = executorService.submit(callable);
		renderText();
		try {
			List<ImageData> list = f.get();
			for (ImageData imageData : list) {
				renderImage(imageData);
			}
		} catch (InterruptedException e) {
			//图片渲染失败
			e.printStackTrace();
		} catch (ExecutionException e) {
			//图片渲染失败
			e.printStackTrace();
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
