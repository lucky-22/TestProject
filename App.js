import React, { useState, useEffect } from "react";
import { NativeEventEmitter, NativeModules, Button, Text, View } from "react-native";

const App = () => {
  const [location, setLocation] = useState(null);
  console.log("Location module");
  const { LocationModule } = NativeModules;
  const locationEventEmitter = new NativeEventEmitter(LocationModule);
  const [click, setClick] = useState(0)

  useEffect(() => {
    const locationUpdateListener = locationEventEmitter.addListener(
      "onLocationUpdate",
      (newLocation) => {
        setLocation(newLocation);
        console.log("Received location update:", newLocation);
      }
    );

    return () => {
      locationUpdateListener.remove();
    };
  }, [click]);

  const getCurrentLocation = () => {

    LocationModule.startLocationUpdates()
    setClick(preV => preV + 1)

  }

  return (
    <View>
      <Button title="Start Location Updates" onPress={() => getCurrentLocation()} />
      {location && (
        <View>
          <Text>Latitude: {location.latitude}</Text>
          <Text>Longitude: {location.longitude}</Text>
          <Text>Accuracy: {location.accuracy}</Text>

        </View>
      )}
    </View>
  );
};

export default App;
