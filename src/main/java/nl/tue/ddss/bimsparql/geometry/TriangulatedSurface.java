/*******************************************************************************
 * Copyright (C) 2017 Chi Zhang
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package nl.tue.ddss.bimsparql.geometry;

import java.util.ArrayList;
import java.util.List;

import nl.tue.ddss.bimsparql.geometry.visitor.GeometryVisitor;

public class TriangulatedSurface extends Surface{
	
	List<Triangle> triangles=new ArrayList<Triangle>();
	
	public TriangulatedSurface(){
	    super();
	}


	public TriangulatedSurface(List< Triangle > triangles){
	    super();
	    this.triangles=triangles;
	}



	public String  geometryType()
	{
	    return "TriangulatedSurface" ;
	}


	public GeometryType geometryTypeId(){
	    return GeometryType.TYPE_TRIANGULATEDSURFACE ;
	}


	public int dimension()
	{
	    //surface
	    return 2 ;
	}


	public int coordinateDimension()
	{
	    if ( triangles.size()==0 ) {
	        return 0 ;
	    }
	    else {
	        return triangles.get(0).coordinateDimension() ;
	    }
	}


	public boolean isEmpty()
	{
	    return triangles.size()==0 ;
	}

	public boolean is3D()
	{
	    return triangles.size()!=0 && triangles.get(0).is3D() ;
	}


	public boolean isMeasured()
	{
	    return triangles.size()!=0 && triangles.get(0).isMeasured() ;
	}


	public void  addTriangles(TriangulatedSurface other )
	{
	    triangles.addAll(other.triangles);
	}



	public int  numGeometries()
	{
	    return numTriangles();
	}


	public void accept( GeometryVisitor visitor )
	{
	    visitor.visit( this );
	}



	public void addTriangle(Triangle triangle) {
		// TODO Auto-generated method stub
		triangles.add(triangle);
	}


	public Triangle geometryN(int i) {
		// TODO Auto-generated method stub
		return triangles.get(i);
	}


	public int numTriangles() {
		// TODO Auto-generated method stub
		return triangles.size();
	}


	public Triangle triangleN(int i) {
		// TODO Auto-generated method stub
		return triangles.get(i);
	}



	@Override
	public Geometry boundary() {
		// TODO Auto-generated method stub
		return null;
	}



	public List<Triangle> getTriangles() {
		// TODO Auto-generated method stub
		return triangles;
	}


}
