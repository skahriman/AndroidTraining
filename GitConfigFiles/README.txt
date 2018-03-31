Making Git configurations

Run the following Git configuration commands. The first one will need to be modified if you are using a text editor other than Sublime, or if Sublime is installed in another location for you. See this page for the correct command for a couple of other popular text editors. For any other editor, you'll need to enter the command you use to launch that editor from the terminal.

#this is where Sublime text editor is stored
git config --global core.editor "/Applications/Sublime\ Text.app/Contents/SharedSupport/bin/subl -n -w"

git config --global push.default upstream
git config --global merge.conflictstyle diff3

(Instead of the first command, you may be able to use the simpler git config --global core.editor "subl -n -w" as shown in the video, but many students have found this does not work for them.)