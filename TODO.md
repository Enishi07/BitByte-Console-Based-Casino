# TODO: Add Tutorial Feature to BitByte Casino

## Steps to Complete

- [ ] Create the Tutorial folder: `BitByte_Casino/Tutorial/`
- [ ] Create `Tutorial.java` in `BitByte_Casino/Tutorial/` with package `tutorial;`
  - [ ] Implement static methods: `showDiceTutorial()`, `showBlackjackTutorial()`, `showSlotMachineTutorial()`, `showColorGameTutorial()`
  - [ ] Each method displays text-based rules for the respective game
- [ ] Modify `BitByteCasino.java`:
  - [ ] Add import: `import tutorial.Tutorial;`
  - [ ] In the switch statement, after game selection, add logic to prompt for tutorial or skip
  - [ ] If tutorial chosen, call the appropriate Tutorial method, then proceed to play
- [ ] Test compilation from the root directory
- [ ] Run the application to verify tutorial display and game flow
