package 동작파라미터화;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class Apple {

	private final int weight;
	private final Color color;

	@Override
	public String toString() {
		return "Apple{" +
			"weight=" + weight +
			", color=" + color +
			'}';
	}

}
