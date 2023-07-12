import { useWindowDimensions, StyleSheet, Text, View, Image } from 'react-native'
import React, { useEffect, useRef, useState } from 'react'
import Mapbox from '@rnmapbox/maps';

Mapbox.setAccessToken('pk.eyJ1IjoibHVja3ktdGhpbmtqcyIsImEiOiJjbGppNjM0dmYwMGtwM2VwazZ4OWZxMDl3In0.A-3SP1h-H3CXkcVLgHePGQ')

const App = () => {

const {height , width} = useWindowDimensions()
const mapRef = useRef(null)
//   camera.current?.setCamera({
//     centerCoordinate: [77.5946,12.9716],
//   });


const [route, setRoute] = useState({
  type: "FeatureCollection",
  features: [
    {
      type: "Feature",
      properties: {},
      geometry: {
        type: "LineString",
        coordinates: [
          // [lng,lat]
          [77.65126, 12.90658],
          [77.65101, 12.9066],
          [77.65065, 12.90661],
          [77.64949, 12.90665],
          [77.64905, 12.90669],
          [77.64905, 12.90669],
          [77.64911, 12.90713],
          [77.64916, 12.90747],
          [77.64919, 12.90767], 
          [77.64931, 12.90834]
        ],
      },
    },
  ],
});

// useEffect(()=>{

//   if (mapRef != null) {
//     console.log(mapRef?.current?.set , 'Map');
//   }

// },[mapRef])


  return (
    <View style={{padding:15}} >
      <View style={styles.page}>
      <View style={{width:width , height:height , backgroundColor:'pink'}}>
        <Mapbox.MapView 
          // ref={mapRef}
         styleURL={'mapbox://styles/lucky-thinkjs/cljxypj67003s01pf37wo4f29'} projection={'globe'} style={styles.map} onLongPress={(e)=>console.log(e , 'longpress')} >
          <Mapbox.Camera ref={mapRef} zoomLevel={19} animationMode={'flyTo'}
                        animationDuration={2100}
                        pitch={70}
                        
                        centerCoordinate={[77.65126, 12.90658]} />
                    
          {/* Marker is working but need to check the loading */}
          {/* <Mapbox.PointAnnotation id={'hello'} coordinate={[77.65126, 12.90658]}> */}
            <Mapbox.MarkerView id={'wow'} coordinate={[77.65126, 12.90658]} >
            <Image src={'https://img.icons8.com/color/48/000000/marker--v1.png'} style={{width:30,height:30}} />  

            </Mapbox.MarkerView>
            {/* <View>
            <Image src={'https://img.icons8.com/color/48/000000/marker--v1.png'} style={{width:30,height:30}} />  
            </View>           */}
          {/* </Mapbox.PointAnnotation> */}


          <Mapbox.ShapeSource id="line1" shape={route}>
          <Mapbox.LineLayer
            id="linelayer1"
            style={{ lineColor: "purple", lineWidth: 5 }}
            />
          </Mapbox.ShapeSource>

                      
          
        </Mapbox.MapView>
      </View>
    </View>
    </View>
  )
}

export default App;

const styles = StyleSheet.create({
  page: {
    justifyContent: 'center',
    alignItems: 'center',
  },
  container: {
    // height: hei,
    // width: windowWidth,
  },
  map: {
    flex: 1
  }
});