/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */
import React from 'react';
import { Alert, StyleSheet, View } from 'react-native';
import VideoPlayer from './specs/VideoPlayerNativeComponent';

function App(): React.JSX.Element {

  return (
    <View style={styles.container}>
      <VideoPlayer
        style={{ width: '100%', height: 300 }}
        playlist="https://content.jwplatform.com/manifests/3BSFM9FJ.m3u8"
        videoIndex={0}
        onScriptLoaded={() => {
          
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});

export default App;
