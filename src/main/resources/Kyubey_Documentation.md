## Getting Started

This guide will explain how to invite and use Kyubey.

### Inviting Kyubey

Click on the invite button on the [main page](https://kyubey.info)

![image](https://cat.girlsare.life/bbc879.png)

You'll be redirected to the bot invite, which looks like this:

![image](https://cat.girlsare.life/9d7130.png)

DO NOT change anything here, it will most likely result in Kyubey not working the way it should.

Select your server and click "Authorize"

![image](https://cat.girlsare.life/1dc10d.png)

Complete the capatcha and you're done! Kyubey is now in your Discord server!

### Using Kyubey

Using Kyubey is simple, you type a prefix with a command after it and done! If the command requires any arguments, Kyubey will automatically detect which argument is missing.

![image](https://cat.girlsare.life/96e370.png)

If you need help on a command you can use the `help` command OR you can use the `--help` flag! 

> Flags are like switches, they can have arguments but most of the time they act as a switch.

> If an argument is surrounded by brackets it means that argument is optional 

![image](https://cat.girlsare.life/59dd8f.png)

The help command gives a lot of information on the command. Arguments required or not and what type, description, subcommands and flags

> Subcommands are like commands on commands, you just execute them by giving them as argument on that command

![image](https://cat.girlsare.life/d779f8.png)

### Customization

Configuring Kyubey looks hard, but its actually really easy!

### Config

Start by executing the `config` command, output will look something like this:

![image](https://cat.girlsare.life/2d5293.png)

To set a setting, use the `set` subcommand on the `config` command with a value:

![image](https://cat.girlsare.life/cb9de3.png)

#### Modlogs

> Modlogs are really nice, they are like audit logs but everyone can see them *and* you can change reasons

Let's enabled modlogs.

We start by enabling it, then we set the channel.

![image](https://cat.girlsare.life/c5cf35.png)

Now we when we kick/ban/mute it *should* log in that channel!

![image](https://cat.girlsare.life/eef425.png)

Let's say we want to change that reason, we can use the `reason` command!

> The reason command also supports ranges and numbers for the case, most of the time you'll only want to use `l` for the latest case.

![image](https://cat.girlsare.life/8ab81c.png)
![image](https://cat.girlsare.life/54942b.png)

#### Starboard

> Starboard is like pins, but it works by "starring" a message (reacting with a star) and everyone can star messages.

To enable starboard, we of course enable it first and then set the channel.

![image](https://cat.girlsare.life/b607e9.png)

Now, when we react with a star to a message it should appear there!

![image](https://cat.girlsare.life/9e55fa.png)
