import type {
  CodegenTypes,
  HostComponent,
  ViewProps,
} from 'react-native';
import {codegenNativeComponent} from 'react-native';
import { Int32 } from 'react-native/Libraries/Types/CodegenTypes';

export interface VideoPlayerProps extends ViewProps {
  playlist: string;
  videoIndex: Int32;
  onScriptLoaded?: CodegenTypes.BubblingEventHandler<VideoPlayerScriptLoadedEvent> | null;
}

type VideoPlayerScriptLoadedEvent = {
  result: 'success' | 'error';
};

export default codegenNativeComponent<VideoPlayerProps>(
  'VideoPlayer',
) as HostComponent<VideoPlayerProps>;