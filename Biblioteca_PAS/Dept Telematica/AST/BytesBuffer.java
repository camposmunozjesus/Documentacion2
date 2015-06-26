class BytesBuffer {
	byte[] bytes;
	int head, tail, num;
	
	BytesBuffer(int size) {
		bytes = new byte[size];
	}
	
	synchronized int read(byte[] b, int off, int len) {
		if (num == 0) {
			try {
				wait();
			} catch (InterruptedException e) { }
		}
		int i;
		for (i = 0; num > 0 && len > 0; i++, num--, len--) {
			b[off + i] = bytes[head];
			head = (head + 1) % bytes.length;
		}
		notify();
		return i;
	}
	
	synchronized void write(byte[] b, int off, int len) {
		do {
			if (num == bytes.length) {
				try {
					wait();
				} catch (InterruptedException e) { }
			}
			for (int i = 0; num < bytes.length && len > 0; i++, num++, len--) {
				bytes[tail] = b[off + i];
				tail = (tail + 1) % bytes.length;
			}
			notify();
		} while (len > 0);
	}
}

class BytesBufferReader {
	BytesBuffer buffer;
	
	BytesBufferReader(BytesBuffer b) {
		buffer = b;
	}
	
	synchronized int read(byte[] b, int off, int len) {
		return buffer.read(b, off, len);
	}
}

class BytesBufferWriter {
	BytesBuffer buffer;
	
	BytesBufferWriter(BytesBuffer b) {
		buffer = b;
	}
	
	synchronized void write(byte[] b, int off, int len) {
		buffer.write(b, off, len);
	}
}

