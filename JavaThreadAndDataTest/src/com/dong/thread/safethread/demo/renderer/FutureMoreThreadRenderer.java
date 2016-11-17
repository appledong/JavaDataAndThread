package com.dong.thread.safethread.demo.renderer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.dong.thread.safethread.bean.ImageData;

/**
 * Future实现的并发下载图片
 * 
 * @author dong
 *
 */
public class FutureMoreThreadRenderer {

	private final ExecutorService executorService = Executors
			.newFixedThreadPool(10); // 10线程的线程池
	
	private final LinkedList<Future<ImageData>> fs = new LinkedList<>();

	/**
	 * 通过future实现一个线程去下载图片，主线程渲染图片
	 * 
	 * @param json
	 */
	public void renderPage(String json) {
		final List<ImageData> images = new ArrayList<>();
		String source = json.toString();// 获取图片的信息
		ImageData imageinfo = scanImageData(source);
		images.add(imageinfo);
		renderText();
		for (final ImageData imageData : images) {
			Callable<ImageData> callable = new Callable<ImageData>() {

				@Override
				public ImageData call() throws Exception {
					return download(imageData) ? imageData : null;
				}

				private boolean download(ImageData imageData) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			Future<ImageData> f = executorService.submit(callable);
			fs.add(f);
		}
		/**
		 * 文本的渲染不能放到图片下载的前面，如果放到前面图片下载后就是图片的
		 * 渲染图片的渲染是阻塞的，不如这样处理的效率更高一些
		 */
		renderText();
		if(fs.size() > 0){
			for (Future<ImageData> future : fs) {
				try {
					ImageData imageData2 = future.get();//上面是多个线程去下载，但是get是阻塞的即下载不完就一只是阻塞的。
					if(imageData2 != null){
						renderImage(imageData2);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
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
