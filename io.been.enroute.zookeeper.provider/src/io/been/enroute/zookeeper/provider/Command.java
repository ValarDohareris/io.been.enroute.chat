package io.been.enroute.zookeeper.provider;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.zookeeper.ZooKeeper;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import osgi.enroute.debug.api.Debug;

@Component(
			property = {
					Debug.COMMAND_SCOPE +"=zk",
					Debug.COMMAND_FUNCTION +"=zk",
					Debug.COMMAND_FUNCTION +"=ls",
					Debug.COMMAND_FUNCTION +"=data"
			},
			service = Command.class
		)
public class Command {
	private ZooKeeper zk;
	
	public String zk() {
		return 
			"zk				help\n"
		+   "ls <path>		list children\n"
		+   "data <path>	show data of node\n";
	}
	
	@Activate
	public void activate() throws IOException{
		this.zk = new ZooKeeper("localhost:6789", 10000, null);
	}
	
	@Deactivate
	public void deactivate() throws Exception{
		this.zk.close();
	}
	
	public List<String> ls(String path) throws Exception {
		return this.zk.getChildren(path, false);
	}
	
	public String data(String path) throws Exception {
		byte[] data = zk.getData(path, false, null);
		return new String(data,  StandardCharsets.UTF_8);
	}
	
}
