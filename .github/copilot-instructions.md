# Copilot Instructions for IP1 - Cryptocurrency Card Game

## Project Overview

This is a **Dominion-inspired card game** with cryptocurrency-themed cards and automation mechanics. The game is a 2-player, fully automated simulation implementing deck-building gameplay in Java (Maven project, Java 23).

## Game Rules (Critical Context)

- **Card Types**: Three category hierarchy:
  - **CryptoCards** (currency): Bitcoin (cost 0, value 1), Ethereum (cost 3, value 2), Doge (cost 6, value 3)
  - **AutomationCards** (victory points): Method (cost 2, value 1), Module (cost 5, value 3), Framework (cost 8, value 6)
- **Starting Setup**: Each player gets 7 Bitcoins + 3 Methods, shuffled into a deck, drawing 5-card hand
- **Turn Structure**:
  1. Buy Phase: Play crypto cards from hand, buy cards ≤ total value
  2. Cleanup: Discard hand and played cards; refill hand from deck (shuffling discard pile as draw pile when empty)
- **Win Condition**: Game ends when all Framework cards (8 total) are purchased; highest total automation card value wins

**Supply Deck**: 14 Methods, 8 Modules, 8 Frameworks, 60 Bitcoins, 40 Ethereums, 30 Dogecoins

## Architecture Patterns

### Card Hierarchy
All cards inherit from `Card` (abstract base with `cost` and `value` fields). Use concrete subclasses `CryptoCard` and `AutomationCard` as intermediate abstractions before leaf types (Bitcoin, Ethereum, Doge, Method, Module, Framework). Keep card types immutable once created—`getValue()` and `getCost()` should remain constant.

### Deck Management
[Deck.java](ip1/src/main/java/edu/brandeis/cosi103a/ip1/Deck.java) uses `ArrayList<Card>` for ordered storage. Standard operations needed: shuffle (reshuffle discard into draw), draw (with pile exhaustion handling), and add cards.

### Player State
[Player.java](ip1/src/main/java/edu/brandeis/cosi103a/ip1/Player.java) manages a single `Deck` instance. Will need: hand (5-card buffer), draw pile, discard pile, buy phase tracking, and automation card total calculation.

## Key Development Workflow

**Build & Test** (Maven):
- Compile: `mvn clean compile`
- Run tests: `mvn test` (JUnit 4 in [AppTest.java](ip1/src/test/java/edu/brandeis/cosi103a/ip1/AppTest.java))
- Package: `mvn package`

**Test Pattern**: JUnit 4 assertions (`assertTrue`, etc.); tests are method-level (e.g., `testRollDie`, `testGameWinner`).

**Core Entry Points**:
- [App.java](ip1/src/main/java/edu/brandeis/cosi103a/ip1/App.java) - `main()` and `playGame()` are stubs; `playGame()` must return winner string and execute full game logic
- Test doubles don't exist; create deterministic test scenarios inline

## Implementation Conventions

1. **Package Structure**: All classes in `edu.brandeis.cosi103a.ip1` package
2. **Inheritance Pattern**: Don't add methods to leaf card classes (Bitcoin, Ethereum, Doge, Method, Module, Framework)—use polymorphism via CryptoCard/AutomationCard abstractions or helper methods in App/Player
3. **State Isolation**: Players manage their own decks independently; use `Deck` as encapsulated data holder
4. **String Return for Winner**: `playGame()` returns player name/ID string (see test expectations: `"Player 1"`, `"Player 2"`, `"Tie"`)

## Missing Pieces to Implement

- Deck shuffling logic (Java `Collections.shuffle()`)
- Player hand/draw/discard pile separation (extend Deck or add to Player)
- Buy phase: value calculation, card purchasing, supply management
- Cleanup phase: discard handling, redraw logic
- Game loop: turn alternation, end-game detection (Framework count), winner determination
