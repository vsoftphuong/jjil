/*
 * Complex2Gray32.java
 *
 * Created on November 5, 2007, 4:12 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 *
 * Copyright 2007 by Jon A. Webb
 *     This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the Lesser GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package jjil.algorithm;
import jjil.core.Complex;
import jjil.core.Complex32Image;
import jjil.core.Gray32Image;
import jjil.core.Image;
import jjil.core.PipelineStage;
/**
 * Converts a Complex32Image to a Gray32Image by taking the complex magnitude of
 * each pixel.
 * @author webb
 */
public class Complex2Gray32 extends PipelineStage {
    
    /**
     * Creates a new instance of Complex2Gray32
     */
    public Complex2Gray32() {
    }
    
    /**
     * Convert an input Complex32Image to an output Gray32Image by taking the 
     * complex magnitude of each pixel.
     * @param im Input image. Must be a Complex32Image.
     * @throws java.lang.IllegalArgumentException If the input is not a Complex32Image.
     */
    public void Push(Image im) throws IllegalArgumentException {
        if (!(im instanceof Complex32Image)) {
            throw new IllegalArgumentException(im.toString() + " should be a" +
                    " Complex32Image, but isn't");
        }
        Gray32Image imResult = new Gray32Image(im.getWidth(), im.getHeight());
        Complex cData[] = ((Complex32Image) im).getData();
        int nData[] = imResult.getData();
        for (int i=0; i<im.getWidth()*im.getHeight(); i++) {
            nData[i] = cData[i].magnitude();
        }
        super.setOutput(imResult);
    }
}
