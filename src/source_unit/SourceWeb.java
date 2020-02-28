package source_unit;

import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import servlet_unit.Buffer;

public class SourceWeb implements SourceInterface {
	private String data;
	
	@Value("${SourceDisk.address}")
	private String address;
//.. other properties in class Parameters

	public SourceWeb() throws IOException {
		
	}
	
	@PostConstruct
	public void doMyInit() throws IOException {
	/**	..так как ясность в понимании работы Spring отсутствует*/
		this.data = Buffer.getText();
	}
	public String getData() {
		return this.data;
	}

	public Parameters getParameters() {
		return new Parameters();
	}

}
