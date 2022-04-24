import cv2
import numpy as np
from PIL import ImageGrab

def screenRec():
    #defining the codec
    fourcc = cv2.VideoWriter_fourcc(*"XVID");
    
    #defining frame rate of the output video
    fps = 30.0
    
    # output video
    out = cv2.VideoWriter("output.avi", fourcc, fps, (1366, 768))

    while True:
        #take snapshot of the screen using imagegrab
        img = ImageGrab.grab()
       
        # convert this image to numpy array
        img_np = np.array(img)
        
        # reads colors as BGR
        frame = cv2.cvtColor(img_np, cv2.COLOR_BGR2RGB)
        
        # Display this frames as video
        win_title = "Screen Recorder"
        cv2.imshow(win_title, frame)
        
        # output the frame
        out.write(frame)
        
        # wait for 'q' key to stop recording (program)
        if cv2.waitKey(1) & 0XFF == ord('q'):
            break
    
    # close the window and release recording
    out.release()
    
    # de-allocate any association memory usage
    cv2.destroyAllWindows()

# call screen recorder function
screenRec()