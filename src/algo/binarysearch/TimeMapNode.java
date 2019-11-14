package algo.binarysearch;
class TimeMapNode {
		String key;
		String value;
		int timestamp;
		 
		TimeMapNode(String key,String value, int timestamp){
			this.key = key;
			this.value = value;
			this.timestamp = timestamp;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public int getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(int timestamp) {
			this.timestamp = timestamp;
		}
		
		
	}