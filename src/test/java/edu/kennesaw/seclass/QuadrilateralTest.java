package edu.kennesaw.seclass;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class QuadrilateralTest {
	Quadrilateral square1, square2, rectangle1, rectangle2, quad;
	
	@BeforeEach
	public void setUp() throws Exception {
		/* Settwo squares,
		 * two rectangles that are not squares,
		 * and a quad that is neither a rectangle nor a square. */
		square1 = new Quadrilateral(new Point(2, 3), new Point(4, 7), new Point(8, 5), new Point(6, 1));
		square2 = new Quadrilateral(new Point(-1, -1), new Point(-1, 1), new Point(1, 1), new Point(1, -1));
		rectangle1 = new Quadrilateral(new Point(4, 2), new Point(3, 4), new Point(9, 7), new Point(10, 5));
		rectangle2 = new Quadrilateral(new Point(-2, -1), new Point(-2, 1), new Point(2, 1), new Point(2, -1));
		quad = new Quadrilateral(new Point(-2, -2), new Point(-1, 1), new Point(1, 1), new Point(1, -1));
	}
	
	@Test
	public void testRectangle() {
		String msg = "Should be a rectangle";
		assertTrue(square1.isRectangle(), msg);
		assertTrue(square2.isRectangle(), msg);
		assertTrue(rectangle1.isRectangle(), msg);
		assertTrue(rectangle2.isRectangle(), msg);
		assertFalse(quad.isRectangle(), "Shouldn't be a rectangle");
	}
	
	@Test
	public void testSquare() {
		String tmsg = "Should be a square";
		String fmsg = "Should not be a square";
		assertTrue(square1.isSquare(), tmsg);
		assertTrue(square2.isSquare(), tmsg);
		assertFalse(rectangle1.isSquare(), fmsg);
		assertFalse(rectangle2.isSquare(), fmsg);
		assertFalse(quad.isSquare(), fmsg);
	}
}
